<template>
    <v-container>
        <v-layout column align-center justify-start >
            <v-btn v-on:click="$router.push({name: 'form', params: {fines: fines, fine: fine}})">
                Новый штраф
            </v-btn>
        </v-layout>
                <fine-row v-for="fine in sortedFines"
                          :key="fine.id"
                          :fine="fine"
                          :editFine="editFine"
                          :deleteFine = "deleteFine"
                          :fines="fines"/>
    </v-container>
</template>

<script>
    import FineForm from "./FineForm.vue";
    import FineRow from "./FineRow.vue";

    export default {
        components: {FineRow, FineForm},
        props: ['fines'],
        data(){
            return {
                fine: null
            }
        },
        computed: {
            sortedFines() {
                return this.fines.sort((a, b) => -(a.id - b.id))
            }
        },
        methods: {
            editFine(fine) {
                this.fine = fine
                this.$router.push({name: 'form', params: {fines: this.fines, fine: this.fine}})
            },
            deleteFine(fine){
                this.$resource('/fines{/id}').remove({id: fine.id}).then(result => {
                    if(result.ok){
                        this.fines.splice(this.fines.indexOf(fine), 1)
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>