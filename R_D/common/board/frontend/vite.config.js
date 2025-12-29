import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig({
  plugins: [vue()],
  build: {
    // 빌드 결과물이 저장될 위치: 백엔드의 static 폴더
    outDir: path.resolve(__dirname, '../backend/src/main/resources/static'),
    // 빌드 시 기존 폴더를 비우고 새로 생성
    emptyOutDir: true,
  }
})