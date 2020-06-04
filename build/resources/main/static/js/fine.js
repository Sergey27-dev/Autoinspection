
function getIndex(list, id){
    for(var i = 0; i < list.length; i++){
        if(list[i].id === id) {
            return i;
        }
    }
    return -1;
}

var fineApi = Vue.resource('/fines{/id}');

Vue.component('fine-form',{
    props: ['fines', 'fineAttr'],
    data: function(){
        return{
            text: '',
            id: ''
        }
    },
    watch: {
        fineAttr: function(newVal, oldVal){
            this.text = newVal.text;
            this.id = newVal.id
        }
    },
    template:
        '<div>'+
        '<input type="text" placeholder="ФИО" v-model="text"/>'+
        '<input type="button" value="Save" @click="save"/>'+
        '</div>',
    methods: {
        save: function () {
            var fine = { text: this.text };
            if(this.id){
                fineApi.update({id: this.id}, fine).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.fines, data.id)
                        this.fines.splice(index, 1, data);
                        this.text = '';
                        this.id = '';
                    })
                )
            }else{
                fineApi.save({}, fine).then(result =>
                    result.json().then(data => {
                        this.fines.push(data);
                        this.text = ''
                    })
                )
            }
        }
    }

});

Vue.component('fine-row',{
    props: ['fine', 'editMethod', 'fines'],
    template:
        '<div><i>({{ fine.id }})</i> {{ fine.text }} ' +
        '<span>' +
        '<input type="button" value="Edit" @click="edit" />'+
        '<input type="button" value="X" @click="del" />'+
        '</span>'+
        '</div>',
    methods: {
        edit: function () {
            this.editMethod(this.fine);
        },
        del: function () {
            fineApi.remove({id: this.fine.id}).then(result =>{
                if(result.ok) {
                    this.fines.splice(this.fines.indexOf(this.fine), 1)
                }
            })
        }
    }
});

Vue.component('fines-list', {
    props: ['fines'],
    data: function(){
        return {
            fine: null
        }

    },
    template:
        '<div>' +
        '<fine-form :fines="fines" :fineAttr="fine"/>'+
        '<fine-row v-for="fine in fines" :key="fine.id" :fine="fine" :editMethod="editMethod" :fines="fines"/>' +
        '</div>',
    created: function () {
        fineApi.get().then(result =>
            result.json().then(data =>
                data.forEach(fine => this.fines.push(fine))
            )
        )
    },
    methods: {
        editMethod: function (fine) {
            this.fine = fine;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<fines-list :fines="fines" />',
    data: {
        fines: [
        ]
    }
});