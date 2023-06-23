<template>
    <div class="protected" v-if="loginSuccess">
        <h1>
            <b-badge variant="success">보안 사이트에 대한 액세스가 허용되었습니다</b-badge>
        </h1>
        <h5>로그인 성공!</h5>
    </div>
    <div class="unprotected" v-else-if="loginError">
        <h1>
            <b-badge variant="danger">이 페이지에 대한 접근 권한이 없습니다.</b-badge>
        </h1>
        <h5>로그인 실패!</h5>
    </div>
    <div class="unprotected" v-else>
        <h1>
            <b-badge variant="info">로그인해주세요</b-badge>
        </h1>
        <h5>로그인 하지 않았습니다. 로그인을 해주세요</h5>
    </div>

    <section class="signin">
        <h1>로그인</h1>
        <div class="signin__card">
            <h4>
                <strong>기술팀에 오신 것을 환영합니다!</strong>
            </h4>
            <form @submit.prevent="login()">
                <input type="text" v-model="user" placeholder="아이디를 입력해주세요">
                <input type="password" v-model="password" placeholder="비밀번호 입력하세요">
                <!-- login/error 처리 -->
                <!-- <p v-if="this.loginError" class="error" text="{{errorMsg}}"></p> -->
                <p v-if="error" class="error">아이디 또는 비밀번호를 확인해주세요.</p>
                <p v-if="error2" class="error">사용자 권한 조회를 실패하였습니다.</p>

                <input type="submit" value="로그인" />
                <p>
                    * 비밀번호를 타 사이트와 같이 사용할 경우 도용 위험이 있으니, 정기적으로 비밀번호를 변경하세요!
                </p>
                <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}">
            </form>
            <div class="actions">
                <a href="/members/new">회원가입</a>
                <!-- <a href="javascript:void(0)">아이디 찾기</a> <a href="javascript:void(0)">비밀번호
                            찾기</a>-->
            </div>
        </div>
    </section>
</template>

<script>
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap/dist/js/bootstrap.js'

export default {
    name: 'login',
    // props: //['loginErrorMsg'],
    // {
    //     loginErrorMsg:{
    //         type:String,
    //         default:null
    //     }
    // },
    created() {
        console.log(this.$route.params.loginErrorMsg);
        console.log(this.errorMsg);
    },
    data() {
        return {
            loginSuccess: false,
            loginError: false,
            errorMsg: '',
            user: '',
            password: '',
            error: false,
            error2: false
        }
    },
    beforeMount() {
        if (typeof loginErrorMsg !== "undefined") {
            console.log(loginErrorMsg);
        }
    },
    methods: {
        async login() {
            this.errors = [];
            this.$store.dispatch("login", { user: this.user, password: this.password })
                .then(() => {
                    this.getRole();
                })
                .catch((error) => { //AxiosError
                    this.loginError = true;
                    this.errors.push(error);
                    this.error = true;
                })
        },
        async getRole() {
            // this.errors = [];
            this.$store.dispatch("getRole", { user: this.user})
                .then(() => {
                    this.$router.push('/')
                })
                .catch((error) => { //AxiosError
                    this.loginError = true;
                    this.errors.push(error);
                    this.error2 = true;
                })
        },
    },
    mounted() {
        gettoken();
        window.scrollTo(0, 0);
    }
}

///csrf token 연결을 위한 테스트 커넥션
async function gettoken() {
    try {
        const result = await axios.get('/api/first_token', '');
        if (result.status === 200) {
            console.log('gettoken ok');
        }
    } catch (err) {
        console.log('gettoken error');
    }
}
</script>

<style scoped="scoped">
@import "https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css";
/* @import "@/css/main.css"; */
@import "https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap";
@import "https://fonts.googleapis.com/icon?family=Material+Icons";
@import "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css";
@import "http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css";
/* //@import "@/css/signin.css"; */

.error {
    color: #bd2130;
}
</style>