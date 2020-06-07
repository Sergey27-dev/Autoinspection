<template>
    <div>
        <div><input type="text" placeholder="ФИО" v-model="text"/></div>
        <div><input type="text" placeholder="Номер машины" v-model="num_car"></div>
        <div><input type="text" placeholder="Номер прав" v-model="num_pas"></div>
        <div><input type="text" placeholder="Вид нарушения" v-model="type"></div>
        <div><input type="text" placeholder="Сумма штрафа" v-model="sum"></div>
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
                sum: '',
                type: '',
                num_pas: '',
                num_car: '',
                text: '',
                id: ''
            }
        },
        watch: {
            fineAttr(newVal, oldVal){
                this.sum = newVal.sum
                this.type = newVal.type
                this.num_pas = newVal.num_pas
                this.num_car = newVal.num_car
                this.text = newVal.text
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                var fine = {
                    sum: this.sum,
                    type: this.type,
                    num_pas: this.num_pas,
                    num_car: this.num_car,
                    text: this.text
                };

                if(this.id){
                    this.$resource('/fines{/id}').update({id: this.id}, fine).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.fines, data.id)
                            this.fines.splice(index, 1, data);
                            this.text = ''
                            this.id = ''
                            this.sum = ''
                            this.type = ''
                            this.num_pas = ''
                            this.num_car = ''
                            this.text= ''
                        })
                    )
                }else{
                    this.$resource('/fines{/id}').save({}, fine).then(result =>
                        result.json().then(data => {
                            this.fines.push(data);
                            this.text = ''
                            this.sum = ''
                            this.type = ''
                            this.num_pas = ''
                            this.num_car = ''
                            this.text= ''
                        })
                    )
                }


            }
        }
    }
</script>

<style scoped>

</style>