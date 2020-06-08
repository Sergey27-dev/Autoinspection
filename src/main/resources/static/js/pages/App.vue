<template>
    <div>
        <v-content>
            <fines-list :fines="fines" />
        </v-content>
    </div>

</template>

<script>
    import FinesList from "../components/fines/FineList.vue"
    export default {
        components: {
            FinesList
        },
        data() {
            return{
                fines: frontendData.fines
            }
        }
    }
</script>

<style scoped>

</style>