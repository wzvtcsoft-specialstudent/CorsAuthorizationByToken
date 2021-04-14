import axios from 'axios'
// import { config } from 'vue/types/umd'

// axios.defaults.withCredentials = true
export default {
  install: function (vue) {
    var auth = vue.prototype.$auth
    // 创建一个axios
    var result = axios.create({
      baseURL: 'http://shop.kinfy.com/api/'
    })
    // 添加一个请求拦截器去处理添加Authorization
    result.interceptors.request.use(config => {
      config.headers.Authorization = auth.getAuthorization()
      return config
    })
    vue.prototype.$http = result
  }
}
