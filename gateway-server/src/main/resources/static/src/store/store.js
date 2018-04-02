import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        username: ''
    },
    mutations: {
        clearSession(state) {
            state.username = ''
        },
        setUsername(state, username) {
            state.username = username
        }
    }
})

export { store };
