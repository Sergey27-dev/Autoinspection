import Vue from 'vue'
import VueRouter from 'vue-router'
import App from "../pages/App.vue";
import MainMenu from "../pages/MainMenu.vue";
import Form from "../pages/Form.vue";
import Login from "../pages/Login.vue";
import Registration from "../pages/Registration.vue";

Vue.use(VueRouter)

const routes = [
    {path: '/', component: MainMenu},
    {path: '/login', component: Login},
    {path: '/reg', component: Registration},
    {path: '/fine', component: App},
    {path: '/fine/form',name: 'form', component: Form, props: true},
    {path: '*', component: MainMenu}
]

export default new VueRouter({
    mode: 'history',
    routes
})