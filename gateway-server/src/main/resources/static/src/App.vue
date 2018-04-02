<template>
    <div>
        <Navigator></Navigator>
        <p>{{ greeting }} World!</p>
    </div>
</template>

<script>
    import Navigator from './components/Navigator';
    import { getUser } from './api/user-api';

    export default {
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
            Navigator
        }
    };
</script>