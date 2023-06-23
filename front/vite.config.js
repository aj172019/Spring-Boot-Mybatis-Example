import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:8089",
        // rewrite: (path) => path.replace(/^\/api/, ""),
        // rewrite: (path) => path.replace(/^\/auth_detail/, /auth_detail/),
      },

    },
    // port:5173      //default
  },
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
      '@store': fileURLToPath(new URL('./src/store', import.meta.url)),
      // '@components': path.resolve(__dirname, './src/components'),
      // '@app_modules': path.resolve(__dirname, './src/modules'),
      // '@store': path.resolve(__dirname, './src/store'),
      // '~bootstrap': path.resolve(__dirname, 'node_modules/bootstrap'),
    }
  }
})


