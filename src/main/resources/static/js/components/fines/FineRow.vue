<template>
    <v-layout align-center justify-start column>
        <v-card raised width="50%" class="my-2">
        <v-card-title>
            Штраф номер<i>({{ fine.id }})</i>
        </v-card-title>
        <v-card-text>
            <div>ФИО: {{ fine.text }}</div>
            <div>Номер машины: {{ fine.num_car }}</div>
            <div>Номер прав: {{ fine.num_pas }}</div>
            <div>Тип нарушения: {{ fine.type }}</div>
            <div>Сумма штрафа: {{ fine.sum }}</div>
        </v-card-text>
        <v-card-actions>
            <v-btn v-on:click="edit">
                Редактировать
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn v-on:click="del">
                Удалить
            </v-btn>
        </v-card-actions>
        </v-card>
    </v-layout>
</template>

<script>
    export default {
        props: ['fine', 'editFine','deleteFine', 'fines'],

        methods: {
            edit() {
                this.editFine(this.fine)
            },
            del() {
                this.deleteFine(this.fine)
            }
        }
    }
</script>

<style scoped>

</style>