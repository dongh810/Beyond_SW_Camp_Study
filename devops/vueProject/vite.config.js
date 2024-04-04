import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/


export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    proxy: {
      '/api': {
        // target: 'http://localhost:7777',
        
        /* 백엔드 프로젝트를 도커 컨테이너에(8055:7777)로 바꾼 이후 */
        // target: 'http://localhost:8055',

        /* 프론트 프로젝트(vue)를 도커 컨테이너(8011:5173)로 바꾸고 도커 네트워크까지 연결이후 */
        target: 'http://springboot-app:7777',

        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
})
