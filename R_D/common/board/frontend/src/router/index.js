import { createRouter, createWebHistory } from 'vue-router'
import BoardList from '../views/BoardList.vue'
import BoardWrite from '../views/BoardWrite.vue'
import BoardDetail from '../views/BoardDetail.vue'
import BoardEdit from '../views/BoardEdit.vue'

const routes = [
  { path: '/', component: BoardList },            // 목록 (홈)
  { path: '/write', component: BoardWrite },      // 글쓰기
  { path: '/detail/:id', component: BoardDetail }, // 상세보기 (ID값 받음)
  { path: '/edit/:id', component: BoardEdit }     // 글 수정 (ID값 받음)
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router