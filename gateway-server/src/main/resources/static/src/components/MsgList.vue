<template>
    <div id="msg-list">
        <MsgDetail v-for="msg in msgList" v-bind:msg="msg" v-bind:key="msg.id"></MsgDetail>
    </div>
</template>
<script>
    import MsgDetail from './MsgDetail';

    export default {
        data() {
            return {
                msgList: [{
                    id: 1,
                    author: 'Jimmy',
                    text: 'What a nice day.'
                }, {
                    id: 2,
                    author: 'Nilson',
                    text: 'Getting tired.'
                }]
            }
        },
        components: {
            MsgDetail
        }
    }
</script>