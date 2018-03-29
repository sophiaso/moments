<template>
    <div>
        <Navigator></Navigator>
        <p>{{ greeting }} World!</p>
    </div>
</template>

<script>
    import Navigator from './components/Navigator';

    export default {
        data: function() {
            return {
                greeting: 'Hello'
            }
        },
        components: {
            Navigator
        }
    };
</script>