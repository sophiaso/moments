<template>
    <div>
        <Navigator></Navigator>
        <MsgEditor v-show="hasLoggedIn()"></MsgEditor>
        <p>{{ greeting }} World!</p>
    </div>
</template>

<script>
    import Navigator from './components/Navigator';
    import MsgEditor from './components/MsgEditor';
    import { getUser } from './api/user-api';
    import mixins from "./components/mixins";

    export default {
        mixins: [mixins],
        data: function() {
            return {
                greeting: 'Hello'
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
            MsgEditor
        }
    };
</script>