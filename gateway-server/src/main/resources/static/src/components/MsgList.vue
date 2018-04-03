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
                    text: 'Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante\n' +
                    ' sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.\n' +
                    ' Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis\n' +
                    ' in faucibus..'
                }, {
                    id: 2,
                    author: 'Nilson',
                    text: 'Donec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo. Cum\n' +
                    ' sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.'
                }]
            }
        },
        components: {
            MsgDetail
        }
    }
</script>
<style>
    #msg-list {
        margin: 16px 0;
    }
</style>