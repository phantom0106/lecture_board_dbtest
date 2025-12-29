<template>
  <div>
    <h1>게시글 목록</h1>
    
    <table border="1" style="width: 100%; border-collapse: collapse;">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in boardList" :key="item.id">
          <td>{{ item.id }}</td>
          <td>
            <router-link :to="'/detail/' + item.id">
              {{ item.title }}
            </router-link>
          </td>
          <td>{{ item.writer }}</td>
          <td>{{ formatDate(item.regDate) }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const boardList = ref([])

const fetchList = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/board')
    console.log('게시판 목록 데이터:', response.data)
    boardList.value = response.data
  } catch (error) {
    console.error('게시판 목록 조회 실패:', error)
  }
}

onMounted(() => {
  fetchList()
})

// 날짜 포맷팅 함수 (T를 공백으로 바꾸고 초 제거)
const formatDate = (dateString) => {
  if (!dateString) return ''
  // "2025-12-28T14:30:00" -> "2025-12-28 14:30"
  return dateString.replace('T', ' ').substring(0, 16)
}
</script>
