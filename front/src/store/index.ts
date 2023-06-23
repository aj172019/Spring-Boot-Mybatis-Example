import { createStore } from 'vuex'
import api from '../api/backend-api'
import createPersistedState from 'vuex-persistedstate';

export default createStore({
    state: {
        loginSuccess: false,
        loginError: false,
        logoutSuccess: false,
        logoutError: false,

        getRoleSuccess: false,
        getRoleError: false,
        userName: null,
        userPass: null,
        userRole: null
    },
    mutations: {
        login_success(state, payload){
            state.loginSuccess = true;
            state.userName = payload.userName;
            state.userPass = payload.userPass;
        },
        login_error(state, payload){
            state.loginError = true;
            // state.userName = payload.userName;
            state.userName = null;
            state.userPass = null;
            state.userRole = null;

            //로그인 처리 해제
            state.loginSuccess = false;
            state.loginError = false;
        },
        
        getRole_success(state, payload){
            state.getRoleSuccess = true;
            state.userRole = payload.userRole;
        },
        getRole_error(state, payload){
            state.getRoleError = true;
        },

        logout_success(state, payload){
            state.logoutSuccess = true;
            state.userName = null;
            state.userPass = null;
            state.userRole = null;

            //로그인 처리 해제
            state.loginSuccess = false;
            state.loginError = false;
        },
        logout_error(state, payload){
            state.logoutError = true;

            //실패해도 로그아웃된 것 처럼 처리
            state.userName = null;
            state.userPass = null;
            state.userRole = null;

            //로그인 처리 해제
            state.loginSuccess = false;
            state.loginError = false;
        },
        logout_try(state, payload){
            //실패해도 로그아웃된 것 처럼 처리
            state.userName = null;
            state.userPass = null;
            state.userRole = null;

            //로그인 처리 해제
            state.loginSuccess = false;
            state.loginError = false;
        }
    },
    actions: {
        login({commit,dispatch }, {user, password}) {
            return new Promise((resolve, reject) => {
                // console.log("Accessing backend with user: '" + user);
                api.getLogin(user, password)
                    .then(response => {
                        //console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                        if(response.status == 200) {
                            console.log("Login successful "+user);
                            // place the loginSuccess state into our vuex store
                            commit('login_success', {
                                userName: user,
                                userPass: password
                            });
                        }
                        resolve(response)
                    })
                    .catch(error => {
                        console.log("Error: " + error);
                        // place the loginError state into our vuex store
                        commit('login_error', {
                            userName: user
                        });
                        reject("Invalid credentials!")
                    })
            })
        },

        logout({commit}) {
            
            //세션체크 반복수행으로 인해서 일단 stroe에서 지우고 로그아웃
            commit('logout_try');

            return new Promise((resolve, reject) => {
                console.log("Accessing backend logout... ");
                api.getLogout()
                    .then(response => {
                        //console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                        if(response.status == 200) {
                            console.log("Logout successful ");
                            commit('logout_success');
                        }
                        resolve(response)
                    })
                    .catch(error => {
                        ///404에러 뜸.
                        console.log("Error: " + error);
                        commit('logout_error');
                        reject("Invalid credentials!")
                    })
            })
        },

        setlogout({commit}) {
            commit('logout_success');
        },
        
        getRole({commit}, {user}) {
            return new Promise((resolve, reject) => {
                // console.log("GetRole Accessing backend with user: '" + user);
                api.getRole(user)
                    .then(response => {
                        // console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                        if(response.status == 200 && response.data.length < 20 ) {
                            console.log("getRole successful "+response.data);
                            commit('getRole_success', {
                                userRole: response.data
                            });
                        }else{
                            console.log("getRole failed code:"+response.status+", data:"+response.data);
                        }
                        resolve(response)
                    })
                    .catch(error => {
                        console.log("Error: " + error);
                        commit('getRole_error', {
                        });
                        reject("Invalid credentials!");
                    })
            })
        }
    },
    getters: {
        isLoggedIn: state => state.loginSuccess,
        hasLoginErrored: state => state.loginError,
        getUserName: state => state.userName,
        getUserPass: state => state.userPass,
        getUserRole: state => state.userRole
    },

    ///vuex 새로고침 시 store가 초기화되는 현상이 있음
    //--> 별도의 persisted api를 통해서 세션에 저장
    // 너무 많이하면 느려짐 -> 이후에 store가 방대해지는 경우 별도 모듈 설정이 필요함.
    plugins: [
      createPersistedState()
    ]
});