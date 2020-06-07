<template>
    <div><i>({{ fine.id }})</i> {{ fine.text }}
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