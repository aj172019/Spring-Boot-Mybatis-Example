<template>
    <!-- Navbar-->
    <!-- <header class="header">
    <nav class="navbar navbar-expand-lg navbar-light py-3">
        <div class="container">
            <a href="#" class="navbar-brand">
                <img src="https://bootstrapious.com/i/snippets/sn-registeration/logo.svg" alt="logo" width="150">
            </a>
        </div>
    </nav>
</header> -->

    <div class="container align-items-center">
        <div class="row py-5 mt-4 align-items-center">
            <!-- For Demo Purpose -->
            <div class="col-md-5 pr-lg-5 mb-5 mb-md-0">
                <img src="https://bootstrapious.com/i/snippets/sn-registeration/illustration.svg" alt=""
                    class="img-fluid mb-3 d-none d-md-block">
                <h1>Create an Account</h1>
                <p class="font-italic text-muted mb-0">Create a minimal registeration page using Bootstrap 4 HTML form
                    elements.</p>
                <p class="font-italic text-muted">Snippet By <a href="https://bootstrapious.com" class="text-muted">
                        <u>Bootstrapious</u></a>
                </p>
            </div>

            <!-- Registeration Form -->
            <div class="col-md-7 col-lg-6 ml-auto">
                <form id="form">
                    <div class="row">

                        <!-- First Name -->
                        <div class="input-group col-lg-6 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-user text-muted"></i>
                                </span>
                            </div>
                            <input type="text" v-model="firstname" placeholder="First Name"
                                class="form-control bg-white border-left-0 border-md">
                        </div>

                        <!-- Last Name -->
                        <div class="input-group col-lg-6 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-user text-muted"></i>
                                </span>
                            </div>
                            <input id="lastName" type="text" v-model="lastname" placeholder="Last Name"
                                class="form-control bg-white border-left-0 border-md">
                        </div>

                        <!-- Email Address -->
                        <div class="input-group col-lg-12 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-envelope text-muted"></i>
                                </span>
                            </div>
                            <input id="email" type="email" v-model="email" placeholder="Email Address"
                                class="form-control bg-white border-left-0 border-md">
                        </div>

                        <!-- Phone Number -->
                        <div class="input-group col-lg-12 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-phone-square text-muted"></i>
                                </span>
                            </div>
                            <input id="phoneNumber" type="tel" v-model="phone" placeholder="Phone Number"
                                class="form-control bg-white border-md border-left-0 pl-3">
                        </div>.


                        <!-- Job -->
                        <div class="input-group col-lg-12 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-black-tie text-muted"></i>
                                </span>
                            </div>
                            <select id="job" v-model="job"
                                class="form-control custom-select bg-white border-left-0 border-md">
                                <option value="">Choose your job</option>
                                <option value="">Designer</option>
                                <option value="">Developer</option>
                                <option value="">Manager</option>
                                <option value="">Accountant</option>
                            </select>
                        </div>

                        <!-- Password -->
                        <div class="input-group col-lg-6 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-lock text-muted"></i>
                                </span>
                            </div>
                            <input id="password" type="password" v-model="password" placeholder="Password"
                                class="form-control bg-white border-left-0 border-md">
                        </div>

                        <!-- Password Confirmation -->
                        <div class="input-group col-lg-6 mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-white px-4 border-md border-right-0">
                                    <i class="fa fa-lock text-muted"></i>
                                </span>
                            </div>
                            <input id="passwordConfirmation" type="text" v-model="password2"
                                placeholder="Confirm Password" class="form-control bg-white border-left-0 border-md">
                        </div>

                        <!-- Submit Button -->
                        <div class="form-group col-lg-12 mx-auto mb-0">
                            <!-- <a href="#" class="btn btn-primary btn-block py-2">
                            <span class="font-weight-bold">Create your account</span>
                        </a>

            <div style="text-align: center">
                <button type="button" @click="submitForm($event)" class="btn btn-info active btn-highlight">회원가입</button>
            </div> -->
                            <span @click="submitForm($event)" class="btn btn-primary btn-block py-2">
                                <span class="font-weight-bold">Create your account</span>
                            </span>
                        </div>

                        <!-- Divider Text -->
                        <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
                            <div class="border-bottom w-100 ml-5"></div>
                            <span class="px-2 small text-muted font-weight-bold text-muted">OR</span>
                            <div class="border-bottom w-100 mr-5"></div>
                        </div>

                        <!-- Already Registered -->
                        <div class="text-center w-100">
                            <p class="text-muted font-weight-bold">Already Registered? <a href="/login"
                                    class="text-primary ml-2">Login</a></p>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script setup>
///import--> index.html로 이동
// @import "//code.jquery.com/jquery-3.3.1.slim.min.js";
// @import "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js";
import { defineProps, computed } from "vue";
import { useRouter, useRoute } from 'vue-router'
import api from '../api/backend-api'

//공통사용
const router = useRouter();
const route = useRoute();

// // 모에서 받아온(props) 데이터를 연결
const props = defineProps({
    modelValue: Object ,
    val_lastname: Object,
    val_email: Object,
    val_password: Object,
    val_password2: Object,
    val_job: Object,
    val_phone: Object
});

props.modelValue="";

///props에 연결할 데이터 정의
const emit = defineEmits(['update:modelValue', 'update:val_lastname', 'update:val_email', 'update:val_password', 'update:val_password2', 'update:val_job', 'update:val_phone'])
const firstname = computed({
    get: () => props.modelValue,
    set: (value) => emit('update:modelValue', value)
});
const lastname = computed({
    get: () => props.val_lastname,
    set: (value) => emit('update:val_lastname', value)
});
const email = computed({
    get: () => props.val_email,
    set: (value) => emit('update:val_email', value)
});
const password = computed({
    get: () => props.val_password,
    set: (value) => emit('update:val_password', value)
});
const password2 = computed({
    get: () => props.val_password2,
    set: (value) => emit('update:val_password2', value)
});
const job = computed({
    get: () => props.val_job,
    set: (value) => emit('update:val_job', value)
});

const phone = computed({
    get: () => props.val_phone,
    set: (value) => emit('update:val_phone', value)
});
// let binding_error = {};



//function
function submitForm(event) {
    event.preventDefault();
    var form = document.getElementById("form");

    const member = {
        firstname: props.val_firstname,
        lastname: props.val_lastname,
        email: props.val_email,
        password: props.val_password,
        job: props.val_job
    };
    api.post("/member_detail/join", member)
        .then((response) => {
            if (response.status == 200) {
                alert('등록이 완료되었습니다.');
                router.push('/login');
            }
        })
        .catch((error) => {
            console.log("Error: " + error);
            console.log("Data: " + error.response.data);
            this.errors = error;

            if (error.response && error.response.data) {
                this.binding_error = error.response.data;
            }
        });
}
</script>

<style scoped="scoped">
@import "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css";
@import "https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css";

.border-md {
    border-width: 2px;
}

.btn-facebook {
    background: #405D9D;
    border: none;
}

.btn-facebook:hover,
.btn-facebook:focus {
    background: #314879;
}

.btn-twitter {
    background: #42AEEC;
    border: none;
}

.btn-twitter:hover,
.btn-twitter:focus {
    background: #1799e4;
}

/*
        *
        * ==========================================
        * FOR DEMO PURPOSES
        * ==========================================
        *
        */

body {
    min-height: 100vh;
}

.container {
    width: 100%;
}

.form-control:not(select) {
    padding: 1.5rem 0.5rem;
}

select.form-control {
    height: 52px;
    padding-left: 0.5rem;
}

.form-control::placeholder {
    color: #ccc;
    font-weight: bold;
    font-size: 0.9rem;
}

.form-control:focus {
    box-shadow: none;
}</style>