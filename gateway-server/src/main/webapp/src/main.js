import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import App from './App'
import { store } from './lib/store'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);

new Vue({
    el: '#app',
    store,
    render: h => h(App)
})


