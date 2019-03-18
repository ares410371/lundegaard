<template>
    <div class="mx-auto w-25" align=""center>
        <h1>Contact us</h1>

        <b-form @submit.prevent="send">
            <div v-if="errors.length">
                <b>Please correct the following error(s):</b>
                <ul>
                    <li v-for="error in errors">{{ error }}</li>
                </ul>
            </div>

            <b-form-group label="Kind of request" label-for="inputType">
                <b-form-select id="inputType" v-model="selected" :options="requestTypes">
                    <template slot="first">
                        <option :value="null" disabled>-- Please select an option --</option>
                    </template>
                </b-form-select>
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
                surname: '',
                errors: []
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
                // if (!this.name.match('^[A-Za-z]+$')) {
                //     this.errors.push('Name must contains only alphabetic characters.')
                // }
                // if (!this.surname.match('^[A-Za-z]+$')) {
                //     this.errors.push('Surname must contains only alphabetic characters.')
                // }
                // if (!this.policyNumber.match('^[A-Za-z0-9]+$')) {
                //     this.errors.push('Policy number must contains only alphanumeric characters.')
                // }
                // if (this.request.length > 2000) {
                //     this.errors.push('Request length must be less than 2000 characters.')
                // }
                //
                // if (this.errors.length !== 0) {
                //     this.errors = [];
                //     return false
                // }

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
                    this.errors.push(e.message)
                })
            }
        }
    }
</script>