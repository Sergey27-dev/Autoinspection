<template>
    <v-content>
        <v-container>
            <v-layout align-center justify-start column>
                <v-form method="post" >
                    <v-text-field name="username" placeholder="Логин"></v-text-field>
                    <v-text-field name="password" type="password" placeholder="Пароль"></v-text-field>
                    <v-layout>
                        <v-btn type="submit" class="mr-2">Войти</v-btn>
                        <v-btn href="/reg">Регистрация</v-btn>
                    </v-layout>
                </v-form>
            </v-layout>
        </v-container>
    </v-content>
</template>

<script>
    export default {
        name: "Login"
    }
</script>

<style scoped>

</style>