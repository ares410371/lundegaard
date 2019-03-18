<template>
    <div class="home">
        <h1>Contact us</h1>
        <b-form @submit.prevent="send">
            <b-form-group label="Kind of request" label-for="inputType">
                <b-form-select id="inputType" v-model="selected" :options="requestTypes"/>
            </b-form-group>

            <b-form-group label="Policy Number" label-for="inputPolicyNumber">
                <b-form-input id="inputPolicyNumber" v-model="policyNumber" type="text"/>
            </b-form-group>

            <b-form-group label="Name" label-for="inputName">
                <b-form-input id="inputName" v-model="name" type="text"/>
            </b-form-group>

            <b-form-group label="Surname" label-for="inputSurname">
                <b-form-input id="inputSurname" v-model="surname" type="text"/>
            </b-form-group>

            <b-form-group label="Your request" label-for="inputRequest">
                <b-form-textarea id="inputRequest" v-model="request" rows="3"/>
            </b-form-group>

            <div class="text-center">
                <b-btn type="submit" variant="primary">Send request</b-btn>
            </div>

        </b-form>
    </div>
</template>

<script>
    export default {
        name: 'home',
        data: function () {
            return {
                requestTypes: [],
                selected: '',
                request: '',
                policyNumber: '',
                name: '',
                surname: ''
            }
        },
        mounted() {
            this.$http.get('/form/types')
                .then(response => {
                    console.log(response.data)
                    this.requestTypes = response.data
                })
        },
        methods: {
            send: function () {
                this.$http.post('/form', {
                    policyNumber: this.policyNumber,
                    name: this.name,
                    surname: this.surname,
                    request: this.request,
                    requestType: this.selected
                }).then(
                    (response) => {}
                ).catch((e) => {
                        console.error(e)
                })
            }
        }
    }
</script>