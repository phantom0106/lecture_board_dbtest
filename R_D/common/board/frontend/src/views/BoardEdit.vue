<template>
  <div>
    <h2>글 수정</h2>
    <form @submit.prevent="handleUpdate">
      <div>
        <label>제목</label><br>
        <input 
          v-model="board.title" 
          type="text" 
          placeholder="제목을 입력하세요" 
          style="width: 100%;"
          required
        />
      </div>
      <div>
        <label>작성자</label><br>
        <input 
          v-model="board.writer" 
          type="text" 
          placeholder="작성자를 입력하세요" 
          style="width: 100%;"
          required
        />
      </div>
      <div>
        <label>내용</label><br>
        <textarea 
          v-model="board.content" 
          placeholder="내용을 입력하세요" 
          style="width: 100%; height: 200px;"
          required
        ></textarea>
      </div>
      <div>
        <button type="submit">수정 완료</button>
        <button type="button" @click="handleCancel">취소</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import axios from 'axios'

const router = useRouter()
const route = useRoute()

const board = ref({
  title: '',
  writer: '',
  content: ''
})

// 1. 처음 화면이 열릴 때 (onMounted)
onMounted(async () => {
  const id = route.params.id
  // 기존 내용을 백엔드에서 빌려와서 화면에 채워 넣습니다.
  const res = await axios.get(`http://localhost:8080/api/board/${id}`)
  board.value = res.data
})

// 2. [수정 완료] 버튼을 눌렀을 때
const handleUpdate = async () => {
  const id = route.params.id
  // 📞 백엔드에게 "이 번호(id)의 글을 이 바구니(board.value)로 바꿔줘!"라고 요청(PUT)
  console.log(board.value)
  await axios.put(`http://localhost:8080/api/board/${id}`, board.value)
  alert("성공적으로 수정되었습니다!")
  router.push(`/detail/${id}`) // 수정한 글의 상세 페이지로 이동
}

const handleCancel = () => {
  if (confirm('수정 중인 내용이 사라집니다. 정말 취소하시겠습니까?')) {
    const id = route.params.id
    router.push(`/detail/${id}`) // 상세 페이지로 돌아가기
  }
}
</script>

