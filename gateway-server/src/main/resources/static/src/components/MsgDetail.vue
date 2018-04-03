<template>
    <div>
        <b-card v-bind:sub-title="msg.author">
            <p class="card-text">
                {{ msg.text }}
            </p>
        </b-card>
    </div>
</template>
<script>
    export default {
        props: ['msg']
    }
</script>