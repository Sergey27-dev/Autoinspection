import Vue from 'vue'
import VueResource from 'vue-resource'
import router from "./router/router.js";
import Menu from "./pages/Menu.vue";
import Vuetify from "vuetify";
import 'vuetify/dist/vuetify.min.css'
/*import '@mdi/font/css/materialdesignicons.css'*/

Vue.use(VueResource)
Vue.use(Vuetify)

new Vue({
    el: '#menu',
    vuetify: new Vuetify(),
    router,
    render: a => a(Menu)
})




