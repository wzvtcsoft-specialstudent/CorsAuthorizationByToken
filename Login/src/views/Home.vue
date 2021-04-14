<template>
<!-- 已登录 -->
  <div v-if="$store.getters['user/isLogin']">
    <div class="member">
      <div class="header-con">
        <div class="user-info">
          <div class="person-con">
            <span>{{ $store.state.user.username }}</span>
          </div>
        </div>
      </div>
        <div @click="logout" class="mui-navigate-right">
          <div class="mui-media-body">退出登录</div>
        </div>
    </div>

  </div>
  <!-- 未登录 -->
  <!-- <div v-else> -->
  <!-- <div class="member"> -->
  <div class="member" v-else>
    <div class="header-con">
      <router-link to="/login" class="mui-navigate-right">
        <div class="user-info">
          <div class="person-con">
            <span>登录</span>
          </div>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    logout () {
      // 1.发送请求完成退出登录
      this.$http.get('logout')
      // 2.将localStorage里面的Authorization干掉
      this.$auth.setAuthorization('')
      // 3.将Vuex中的用户信息删除
      this.$store.commit('user/logout')
      // 4.提示用户退出成功
      this.$toast('退出成功')
    }
  }
}
</script>

<style lang="scss" scoped>
.member {
  margin-bottom: 15px;
  .header-con {
    padding: 10px;
    background-color: #fff;
    .user-info {
      position: relative;
      overflow: hidden;
      width: 100%;
      height: 120px;
      background: linear-gradient(90deg, #28a2ff, #ffd787);
      box-shadow: 0 0.1rem 0.25rem #f8e3c6;
      .person-con {
        position: absolute;
        left: 45%;
        top: 50%;
        transform: translateY(-50%);
        color: #fff;
      }
    }
  }
}
</style>
