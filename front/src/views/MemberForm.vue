<style scoped="scoped">
/* //@import "@/css/font.css";
//@import "@/css/common.css";
//@import "@/css/layout1.css"; */
@import "https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css";
/* @import "@/css/main.css"; */
@import "https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap";
@import "https://fonts.googleapis.com/icon?family=Material+Icons";
@import "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css";
@import "http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css";

.input-group {
    margin-bottom: 15px
}

.img-div {
    margin-bottom: 10px
}

.fieldError {
    color: #bd2130;
}
</style>

<template>
    <div class="content_vue">
        <h4 class="icando-page-title">회원 가입</h4>
        <hr>

        <form id="form" >
            <p v-if="binding_error.errorMessage!=null" class="fieldError">{{binding_error.errorMessage}}</p>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" v-model="member.name" class="form-control" placeholder="이름을 입력해주세요">
                <p v-if="binding_error.name!=null" class="fieldError">{{binding_error.name}}</p>
            </div>
            <div class="form-group">
                <label for="email">이메일주소</label>
                <input type="email" v-model="member.email" class="form-control" placeholder="이메일을 입력해주세요">
                <p v-if="binding_error.email!=null" class="fieldError">{{binding_error.email}}</p>
                <!-- <p th:if="${#fields.hasErrors('email')}" th:errors="*{email}" class="fieldError">Incorrect data</p> -->
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" v-model="member.password" class="form-control" placeholder="비밀번호 입력">
                <p v-if="binding_error.password!=null" class="fieldError">{{binding_error.password}}</p>
                <!-- <p th:if="${#fields.hasErrors('password')}" th:errors="*{password}" class="fieldError">Incorrect data</p> -->
            </div>
            <div class="form-group">
                <label for="address">주소</label>
                <input type="text" v-model="member.address" class="form-control" placeholder="주소를 입력해주세요">
                <p v-if="binding_error.address!=null" class="fieldError">{{binding_error.address}}</p>
                <!-- <p th:if="${#fields.hasErrors('address')}" th:errors="*{address}" class="fieldError">Incorrect data</p> -->
            </div>
            <div style="text-align: center">
                <button type="button" @click="submitForm($event)" class="btn btn-info active btn-highlight">회원가입</button>
            </div>
            <!-- csrf->axios 처리 -->
            <!-- <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"> -->
        </form>
    </div>
</template>

<script>
import api from '@/api/backend-api.ts';
// import common from "@components/common/common.js"

export default ({
    name: 'MemberForm',
    created() {
        this.id = this.$route.params.itemid ? this.$route.params.itemid : null;
    },
    mounted() {
    },
    data() {
        return {
            // id: null,
            member: {
                name:null,
                email:null,
                password:null,
                address:null
            },
            errorMessage: null,
            alertMessage: null,
            binding_error:{
                name:null,
                email:null,
                password:null,
                address:null

            }
        }
    },
    methods: {
        submitForm(event) {
            event.preventDefault();
            var form = document.getElementById("form");

            api.post("/member_detail/create", this.member)
                .then((response) => {
                    if (response.status == 200) {
                        alert('등록이 완료되었습니다.');
                        this.$router.push('/members/login');
                    }
                })
                .catch((error) => {
                    console.log("Error: " + error);
                    console.log("Data: " + error.response.data);
                    this.errors = error;

                    if(  error.response && error.response.data){
                        this.binding_error = error.response.data;
                    }
                });
        },
    },

    compatConfig: {
        MODE: 3
    }
});
</script>