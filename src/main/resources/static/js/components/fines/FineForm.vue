<template>
    <v-layout justify-start align-center column>
        <v-text-field
                placeholder="ФИО"
                v-model="text"
        ></v-text-field>
        <v-text-field
                placeholder="Номер машины"
                v-model="num_car"
        ></v-text-field>
        <v-text-field
                placeholder="Номер прав"
                v-model="num_pas"
        ></v-text-field>
        <v-text-field
                placeholder="Вид нарушения"
                v-model="type"
        ></v-text-field>
        <v-text-field
                placeholder="Сумма штрафа"
                v-model="sum"
        ></v-text-field>
        <v-layout row>
            <v-btn v-on:click="save" class="mr-2" color="green">Сохранить</v-btn>
            <v-btn href="/fine">Назад</v-btn>
        </v-layout>
    </v-layout>
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

        created() {
            if(this.fineAttr!=null){
                this.sum = this.fineAttr.sum
                this.type = this.fineAttr.type
                this.num_pas = this.fineAttr.num_pas
                this.num_car = this.fineAttr.num_car
                this.text = this.fineAttr.text
                this.id = this.fineAttr.id
            }

        },
        methods: {
            save() {
                let fine = {
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
                            this.$router.push('/fine')
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
                            this.$router.push('/fine')
                        })
                    )
                }


            }
        }
    }
</script>

<style scoped>

</style>