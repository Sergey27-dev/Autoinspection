<template>
    <div>
        <div>
            <fines-list :fines="fines" />
        </div>
    </div>

</template>

<script>
    import FinesList from "../components/fines/FineList.vue"
    export default {
        components: {FinesList},
        data() {
            return{
                fines: frontendData.fines
            }
        }
    }
</script>

<style scoped>

</style>