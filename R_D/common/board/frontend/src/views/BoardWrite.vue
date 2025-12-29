<template>
  <div>
    <h2>글쓰기</h2>
    <form @submit.prevent="handleSubmit">
      <div>
        <label>제목</label><br>
        <input 
          v-model="formData.title" 
          type="text" 
          placeholder="제목을 입력하세요" 
          style="width: 100%;"
          required
        />
      </div>
      <div>
        <label>작성자</label><br>
        <input 
          v-model="formData.writer" 
          type="text" 
          placeholder="작성자를 입력하세요" 
          style="width: 100%;"
          required
        />
      </div>
      <div>
        <label>내용</label><br>
        <textarea 
          v-model="formData.content" 
          placeholder="내용을 입력하세요" 
          style="width: 100%; height: 200px;"
          required
        ></textarea>
      </div>
      <div>
        <button type="submit">저장하기</button>
        <button type="button" @click="handleCancel">취소</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

const router = useRouter()

const formData = ref({
  title: '',
  writer: '',
  content: ''
})

const handleSubmit = async () => {
  if (!formData.value.title || !formData.value.writer) {
    alert('제목과 작성자를 입력해주세요!')
    return
  }

  try {
    await axios.post('http://localhost:8080/api/board', formData.value)
    alert('성공적으로 저장되었습니다!')
    router.push('/')
  } catch (err) {
    alert('저장 실패 ㅠㅠ')
  }
}

const handleCancel = () => {
  if (confirm('작성 중인 내용이 사라집니다. 정말 취소하시겠습니까?')) {
    router.push('/')
  }
}
</script>
