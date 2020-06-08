<template>
    <fine-form :fines="fines" :fineAttr="fine"/>
</template>

<script>
    import FineForm from "../components/fines/FineForm.vue";
    export default {
        components: {FineForm},
        props: ['fines', 'fine', 'editFine'],
    }
</script>

<style scoped>

</style>