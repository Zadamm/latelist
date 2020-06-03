import Vue from 'vue'
import Vuex from 'vuex'
import api from './components/backend-api'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginSuccess: false,
        loginError: false,
        userName: null,
        userPass: null,
        lateTimes: []
    },
    mutations: {
        login_success(state, payload){
            state.loginSuccess = true;
            state.userName = payload.userName;
            state.userPass = payload.userPass;
        },
        login_error(state, payload){
            state.loginError = true;
            state.userName = payload.userName;
        },
        setLateTimes(state, latetimes){
            state.lateTimes = latetimes
        }
    },
    actions: {
        login({commit}, {user, password}) {
            return new Promise((resolve, reject) => {
                console.log("Accessing backend with user: '" + user);
                api.getSecured(user, password)
                    .then(response => {
                        console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                        if(response.status == 200) {
                            console.log("Login successful");
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
        loadLateTimes({commit}) {
            api.getLateTimes()
              .then(response => {
                  commit('setLateTimes', response.data);
              })
              .catch(error => {
                  console.log("Error: " + error);
              })
        }
    },
    getters: {
        isLoggedIn: state => state.loginSuccess,
        hasLoginErrored: state => state.loginError,
        getUserName: state => state.userName,
        getUserPass: state => state.userPass,
        getAggregateLateTimes: state => {
            if (state.lateTimes.length !== 0) {
                let aggregate = new Map();
                state.lateTimes.forEach((lateTime) => {
                    if (aggregate.has(lateTime.name)) {
                        aggregate.set(lateTime.name, aggregate.get(lateTime.name) + lateTime.duration);
                    } else {
                        aggregate.set(lateTime.name, lateTime.duration);
                    }
                })
                const sorted = Array.from(aggregate.entries(), (entry) => {
                    console.log(entry)
                    return  { name: entry[0], duration: entry[1] }
                }).sort((a,b) => b.duration - a.duration);
                console.log(sorted);
                return sorted;
            } else {
                return [];
            }
        }
    }
})