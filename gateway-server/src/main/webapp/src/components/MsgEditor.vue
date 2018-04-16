<template>
    <div id="msg-editor">
        <b-form-textarea id="textarea1"
                         v-model="msg"
                         placeholder="Enter something"
                         :rows="3"
                         :max-rows="6">
        </b-form-textarea>
        <b-button id="post-btn" variant='info'>Post</b-button>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                msg: ''
            }
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