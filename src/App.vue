<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  methods: {
    checkLogin () {
      this.$http.get('user').then((res) => {
        if (res.data.code === 1) {
          // 如果用户信息已经登录过，那么就将用户信息返回到vuex中
          this.$store.commit('user/setUser', res.data.data)
        }
      })
    }
  },
  created () {
    this.checkLogin()
  }
}
</script>

 <style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
