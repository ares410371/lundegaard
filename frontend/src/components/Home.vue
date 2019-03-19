<template>
    <div class="mx-auto w-50" align="" center>
        <h1>Contact us</h1>

        <b-form @submit.prevent="send">
            <b-form-group label="Kind of request" label-for="inputType">
                <b-form-select id="inputType" v-model="selected" :options="requestTypes">
                    <template slot="first">
                        <option :value="null" disabled>-- Please select an option --</option>
                    </template>
                </b-form-select>
            </b-form-group>

            <b-form-group label="Policy Number" label-for="inputPolicyNumber">
                <b-input id="inputPolicyNumber" v-model="policyNumber" type="text" name="policyNumber"
                         :class="{'input': true, 'is-danger': errors.has('policyNumber') }"/>
                <i v-show="errors.has('policyNumber')" class="fa fa-warning"></i>
                <span v-show="errors.has('policyNumber')"
                      class="help is-danger">{{ errors.first('policyNumber') }}</span>
            </b-form-group>

            <b-form-group label="Name" label-for="inputName">
                <b-input id="inputName" v-model="name" type="text" name="name"
                         :class="{'input': true, 'is-danger': errors.has('name') }"/>
                <i v-show="errors.has('name')" class="fa fa-warning"></i>
                <span v-show="errors.has('name')" class="help is-danger">{{ errors.first('name') }}</span>
            </b-form-group>

            <b-form-group label="Surname" label-for="inputSurname">
                <b-form-input id="inputSurname" v-model="surname" type="text" name="surname"
                              class="{'input': true, 'is-danger': errors.has('surname') }"/>
                <i v-show="errors.has('surname')" class="fa fa-warning"></i>
                <span v-show="errors.has('surname')" class="help is-danger">{{ errors.first('surname') }}</span>
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
    import {Validator} from "vee-validate";

    export default {
        name: 'home',
        validator: null,
        data() {
            return {
                requestTypes: [],
                selected: '',
                request: '',
                policyNumber: '',
                name: '',
                surname: '',
                errors: null
            }
        },
        mounted() {
            this.$http.get('/form/types')
                .then(response => {
                    console.log(response.data);
                    this.requestTypes = response.data;
                })
        },
        watch: {
            name(value) {
                this.validator.validate("name", value);
            },
            surname(value) {
                this.validator.validate("surname", value);
            },
            policyNumber(value) {
                this.validator.validate("policyNumber", value);
            },
            request(value) {
                this.validator.validate("request", value);
            }
        },
        methods: {
            send: function () {
                this.validator.validateAll({
                    name: this.name,
                    surname: this.surname,
                    policyNumber: this.policyNumber,
                    request: this.request
                }).then(result => {
                    console.log(result);
                    if (result) {
                        this.$http.post('/form', {
                            policyNumber: this.policyNumber,
                            name: this.name,
                            surname: this.surname,
                            request: this.request,
                            requestType: this.selected
                        }).then(
                            (response) => {
                            }
                        ).catch((e) => {
                            console.error(e);
                        });
                        alert('Form Submitted!');
                        return;
                    }
                    alert('Correct them errors!');
                })
            }
        },
        created() {
            this.validator = new Validator({
                name: 'alpha',
                surname: 'alpha',
                policyNumber: 'alpha_num',
                request: 'max:2000'
            });
            this.$set(this, 'errors', this.validator.errors);
        }
    }
</script>