<template>
    <v-app>
        <v-app-bar app hide-on-scroll>
            <v-toolbar-title><v-btn href="/" flat>Autoinspection</v-btn></v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn v-if="profile!=null" href="/logout">Выход</v-btn>
            <v-btn v-else href="/login">Войти</v-btn>
        </v-app-bar>
        <v-content>
            <div>
                <router-view></router-view>
            </div>
        </v-content>
    </v-app>


</template>

<script>
    import MainMenu from "./MainMenu.vue";
    export default {
        components: {MainMenu},
        data() {
            return{
                profile: frontendData.profile
            }

        },
        comments: {
            MainMenu
        },
        name: "Menu",
        methods: {
            call_menu(){
                this.$router.push('/menu')
            }
        }
    }
</script>

<style scoped>

</style>