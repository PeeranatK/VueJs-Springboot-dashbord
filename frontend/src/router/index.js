import { createRouter, createWebHistory } from 'vue-router'
//import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import LoginView from '../views/LoginView.vue'
import DashBoard from '../views/DashBoard.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: DashBoard
    }
  ]
})

export default router
