<template>
    <div id="msg-editor">
        <b-form-textarea id="textarea1"
                         v-model="msg"
                         placeholder="Enter something"
                         :rows="3"
                         :max-rows="6">
        </b-form-textarea>
        <pre class="mt-3">{{ msg }}</pre>
        <b-button variant='primary'>Post</b-button>
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
</style>