<template>
    <div><i>({{ fine.id }})</i>
        <div>ФИО: {{ fine.text }}</div>
        <div>Номер машины: {{ fine.num_car }}</div>
        <div>Номер прав: {{ fine.num_pas }}</div>
        <div>Тип нарушения: {{ fine.type }}</div>
        <div>Сумма штрафа: {{ fine.sum }}</div>
    <span>
        <input type="button" value="Edit" @click="edit" />
        <input type="button" value="X" @click="del" />
        </span>
    </div>
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