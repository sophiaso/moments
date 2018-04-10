<template>
    <div>
        <b-card class="msg-detail">
            <b-media>
                <b-img class="img-icon" slot="aside" blank blank-color="#abc" width="32" alt="placeholder" />
                <h5 class="mt-0">{{msg.author}}</h5>
                <p>
                    {{ msg.text }}
                </p>
            </b-media>
        </b-card>
    </div>
</template>
<script>
    import Vue from 'vue'
    import { Media } from 'bootstrap-vue/es/components';

    Vue.use(Media);

    export default {
        props: ['msg']
    }
</script>
<style>
    .img-icon {
        margin-top: 3px;
    }

    .msg-detail {
        border: 0px;
        border-bottom: 1px solid rgba(0,0,0,0.125);
    }

    .msg-detail .card-body{
        padding: 1rem 0 0 0;
    }
</style>