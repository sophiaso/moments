<template>
    <div>
        <b-nav>
            <b-nav-item active>Active</b-nav-item>
            <b-nav-item>Link</b-nav-item>
        </b-nav>
    </div>
</template>
<script>
    import bNav from 'bootstrap-vue/es/components/nav/nav';
    import bNavItem from 'bootstrap-vue/es/components/nav/nav-item';

    export default {
        components: {
            'b-nav': bNav,
            'b-nav-item': bNavItem
        }
    };
</script>