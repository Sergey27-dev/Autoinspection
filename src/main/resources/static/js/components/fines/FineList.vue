<template>
    <div>
        <fine-form :fines="fines" :fineAttr="fine"/>
        <fine-row v-for="fine in fines"
                  :key="fine.id"
                  :fine="fine"
                  :editFine="editFine"
                  :deleteFine = "deleteFine"
                  :fines="fines"/>
    </div>
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
        methods: {
            editFine(fine) {
                this.fine = fine
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