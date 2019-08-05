import Vue from 'vue'
import App from './App.vue'

import axios from "axios";
import router from './router'

import blog from "@/config/config";
Vue.prototype.$blog = blog;

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI);

Vue.config.productionTip = false
Vue.prototype.$ajax = axios;

import { getCookie, setCookie, delCookie } from "@/utils/cookie";
Vue.prototype.$cookieStore = {
  getCookie,
  setCookie,
  delCookie
}

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
Vue.use(mavonEditor);


// import HighLight from '@/utils/highlight.js'
// Vue.use(HighLight);

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
