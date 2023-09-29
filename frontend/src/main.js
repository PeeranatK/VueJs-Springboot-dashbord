import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
//import bootstrap from 'bootstrap/dist/js/bootstrap.bundle'


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueSweetalert2 from 'vue-sweetalert2';



const app = createApp(App)

app.use(router)
app.use(VueSweetalert2);
//app.use(bootstrap);

// Vue.use(BootstrapVue);

// // Optionally install the BootstrapVue icon components plugin
// Vue.use(IconsPlugin);

app.mount('#app')
