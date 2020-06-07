<template>
    <div>
        <input type="text" placeholder="ФИО" v-model="text"/>
        <input type="button" value="Save" @click="save"/>
    </div>
</template>

<script>
    function getIndex(list, id){
        for(var i = 0; i < list.length; i++){
            if(list[i].id === id) {
                return i;
            }
        }
        return -1
    }
    export default {
        props: ['fines', 'fineAttr'],
        data(){
            return{
                text: '',
                id: ''
            }
        },
        watch: {
            fineAttr(newVal, oldVal){
                this.text = newVal.text;
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                var fine = { text: this.text };

                if(this.id){
                    this.$resource('/fines{/id}').update({id: this.id}, fine).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.fines, data.id)
                            this.fines.splice(index, 1, data);
                            this.text = '';
                            this.id = '';
                        })
                    )
                }else{
                    this.$resource('/fines{/id}').save({}, fine).then(result =>
                        result.json().then(data => {
                            this.fines.push(data);
                            this.text = ''
                        })
                    )
                }


            }
        }
    }
</script>

<style scoped>

</style>