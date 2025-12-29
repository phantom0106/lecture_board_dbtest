<template>
  <div v-if="board">
    <h2>글 상세보기</h2>
    <hr>
    <p><strong>번호:</strong> {{ board.id }}</p>
    <p><strong>제목:</strong> {{ board.title }}</p>
    <p><strong>작성자:</strong> {{ board.writer }}</p>
      <p><strong>작성일:</strong> {{ formatDate(board.regDate) }}</p>
    <div style="border: 1px solid #ccc; padding: 20px; min-height: 200px;">
      {{ board.content }}
    </div>
    <hr>
    <button @click="$router.push('/')">목록으로</button>
    <button @click="handleEdit" style="background-color: #4a9eff; color: white; margin-left: 10px;">수정</button>
    <button @click="handleDelete" style="background-color: #ff4d4d; color: white; margin-left: 10px;">삭제하기</button>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import axios from 'axios'

const router = useRouter()
const route = useRoute()
const board = ref(null)

const fetchDetail = async () => {
  try {
    const id = route.params.id
    const url = `http://localhost:8080/api/board/${id}`
    const res = await axios.get(url)
    board.value = res.data

  } catch (error) {
    console.error('❌ [에러] 상세 조회 실패:', error)
    console.error('❌ [에러] 에러 메시지:', error.message)
    alert('게시글을 불러올 수 없습니다: ' + (error.response?.data?.message || error.message))
  }
}

onMounted(fetchDetail)

// 수정 기능
const handleEdit = () => {
  const id = route.params.id
  router.push(`/edit/${id}`)
}

// 삭제 기능
const handleDelete = async () => {
  // 1. 진짜 지울 건지 물어봅니다 (실수 방지)
  if (confirm("정말 이 글을 지울까요?")) {
    try {
      // 2. 백엔드 주소로 'DELETE' 전화를 겁니다.
      const id = route.params.id
      await axios.delete(`http://localhost:8080/api/board/${id}`)
      
      // 3. 지워졌으면 알려주고 목록으로 보냅니다.
      alert("글이 깨끗하게 지워졌어요!")
      router.push('/')
    } catch (error) {
      alert("앗, 지우는 도중에 문제가 생겼어요.")
    }
  }
}

// 날짜 포맷팅 함수 (T를 공백으로 바꾸고 초 제거)
const formatDate = (dateString) => {
  if (!dateString) return ''
  // "2025-12-28T14:30:00" -> "2025-12-28 14:30"
  return dateString.replace('T', ' ').substring(0, 16)
}
</script>
