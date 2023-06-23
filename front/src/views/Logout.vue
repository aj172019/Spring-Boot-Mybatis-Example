<style scoped="scoped">

</style>

<template>
    <!--HEADER-->
    <div class="content_vue">
        Logout
    </div>
</template>

<script>
import { $, jQuery } from 'jquery';
import store from "@store"

export default ({
    name: 'Logout',

    data(){
        return{
            errors:[]
        }
    },

    mounted() {
        this.logout();
        window.scrollTo(0, 0);
    },

    compatConfig: {
        MODE: 3
    },

    methods: {
        async logout() {
            store.dispatch("logout")
                .then(response => {
                    if (response.status == 200) {
                        alert("로그아웃 완료되었습니다.");
                        this.$router.push('/');
                    }
                    else {
                        console.log("로그아웃 실패...");
                        this.$router.push('/');
                    }
            
                })
                .catch((error) => { //AxiosError
                    this.loginError = true;
                    this.errors.push(error);
                    this.error = true;
                    // console.log("로그아웃 실패...");
                });

            this.$router.push('/');
        }
    }
});
</script>