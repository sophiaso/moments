<template>
    <div>
        <Navigator></Navigator>
        <b-container>
            <b-row align-h="center">
                <b-col cols="8">
                    <MsgEditor v-show="hasLoggedIn()"></MsgEditor>
                    <MsgList></MsgList>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import Vue from 'vue'
    import { Layout } from 'bootstrap-vue/es/components';
    import Navigator from './components/Navigator';
    import MsgEditor from './components/MsgEditor';
    import MsgList from './components/MsgList';
    import { getUser } from './api/user-api';
    import mixins from "./components/mixins";

    Vue.use(Layout);

    export default {
        mixins: [mixins],
        data: function() {
            return {
            }
        },
        created: function () {
            getUser().then(res => {
                if(res.data.principal) {
                    this.$store.commit('setUsername', res.data.principal.username);
                }
            }).catch(err =>{
                console.log(err);
            });
        },
        components: {
            Navigator,
            MsgEditor,
            MsgList
        }
    };
</script>