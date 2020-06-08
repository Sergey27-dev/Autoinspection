<template>
    <v-content>
        <v-container>
            <v-layout justify-start align-center column>
                <v-form action="/registration" method="post">
                    <v-text-field name="username" placeholder="Логин"></v-text-field>
                    <v-text-field name="password" type="password" placeholder="Пароль"></v-text-field>
                    <v-layout>
                        <v-btn type="submit">Зарегистрироваться</v-btn>
                    </v-layout>
                </v-form>
            </v-layout>
        </v-container>
    </v-content>
</template>

<script>
    export default {
    }
</script>

<style scoped>

</style>