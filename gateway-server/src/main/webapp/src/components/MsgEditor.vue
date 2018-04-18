<template>
    <div id="msg-editor">
        <b-form-textarea id="textarea1"
                         v-model="msg"
                         placeholder="Enter something"
                         :rows="3"
                         :max-rows="6">
        </b-form-textarea>
        <b-button id="post-btn" variant='info' @click="sendMessage">Post</b-button>
    </div>
</template>
<script>
    import Stomp from 'stompjs';
    import SockJS from 'sockjs-client';
    import EventBus from '../lib/event-bus';

    const socketUrl = "/message/moments-message"

    export default {
        data() {
            return {
                msg: '',
                stompClient: null
            }
        },
        methods: {
            initConnection: function () {
                let ws = new SockJS(socketUrl);
                this.stompClient = Stomp.over(ws);
                let _this = this;
                this.stompClient.connect({}, function (frame) {
                    console.log("Connected: " + frame);
                    _this.stompClient.subscribe('/topic/messages', function (message) {
                        console.log("Received message: " + message);
                        let msgBody = JSON.parse(message.body);
                        EventBus.$emit('RECV_MSG', {
                            author: msgBody.name,
                            text: msgBody.message
                        });
                    });
                },
                function (frame) {
                    console.log("Connection failed with error: " + frame)
                });
            },

            sendMessage() {
                this.stompClient.send("/app/onMessage" , {},
                    JSON.stringify({
                        name: this.$store.state.username,
                        message: this.msg
                    }));
            }
        },
        mounted: function() {
            this.initConnection();
        }
    }
</script>
<style>
    #msg-editor {
        width: 100%;
        display: inline-block;
        padding: 16px 0;
        background-color: rgba(240,255,255, 0.5);
    }

    #post-btn {
        margin: 16px 0;
        float:right;
    }
</style>