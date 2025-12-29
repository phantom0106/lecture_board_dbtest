<script setup>
</script>

<template>
  <div class="app-container">
    <nav class="navbar">
      <div class="nav-content">
        <router-link to="/" class="nav-logo">
          <span class="logo-icon">📋</span>
          <span class="logo-text">게시판</span>
        </router-link>
        <div class="nav-links">
          <router-link to="/" class="nav-link">목록</router-link>
          <router-link to="/write" class="nav-link write-link">글쓰기</router-link>
        </div>
      </div>
    </nav>
    <main class="main-content">
      <router-view />
    </main>
  </div>
</template>

<style scoped>
.app-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #0f1419 0%, #1a1a2e 50%, #16213e 100%);
}

.navbar {
  background: linear-gradient(135deg, #1a1a2e 0%, #16213e 100%);
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
  position: sticky;
  top: 0;
  z-index: 1000;
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
}

.nav-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 1rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.nav-logo {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  text-decoration: none;
  color: #e0e0e0;
  font-size: 1.5rem;
  font-weight: 700;
  transition: transform 0.2s ease;
}

.nav-logo:hover {
  transform: scale(1.05);
}

.logo-icon {
  font-size: 2rem;
}

.logo-text {
  background: linear-gradient(135deg, #4a9eff 0%, #6b7fd7 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.nav-links {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.nav-link {
  padding: 0.6rem 1.2rem;
  text-decoration: none;
  color: #b0b0b0;
  font-weight: 500;
  border-radius: 8px;
  transition: all 0.3s ease;
}

.nav-link:hover {
  background: rgba(74, 158, 255, 0.15);
  color: #4a9eff;
}

.nav-link.router-link-active {
  background: linear-gradient(135deg, #1e3a5f 0%, #2c3e50 100%);
  color: #e0e0e0;
}

.write-link {
  background: linear-gradient(135deg, #1e3a5f 0%, #2c3e50 100%);
  color: #e0e0e0;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.3);
}

.write-link:hover {
  background: linear-gradient(135deg, #2c4a6f 0%, #3c5e70 100%);
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.4);
  color: #ffffff;
}

.main-content {
  padding: 2rem 0;
  min-height: calc(100vh - 80px);
}

@media (max-width: 768px) {
  .nav-content {
    padding: 1rem;
    flex-direction: column;
    gap: 1rem;
  }
  
  .nav-links {
    width: 100%;
    justify-content: space-around;
  }
  
  .nav-link {
    flex: 1;
    text-align: center;
  }
}
</style>