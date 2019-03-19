import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VeeValidate from 'vee-validate';

Vue.prototype.$http = axios;
Vue.config.productionTip = false;

// Bootstrap
Vue.use(BootstrapVue);
Vue.use(VeeValidate);

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');

