import { createApp } from 'vue'
import './global.css'
import App from './App.vue'
import * as VueRouter from 'vue-router'
import routes from "./config/route.ts";

const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(),
    routes,
})

createApp(App).use(router).mount('#app')
