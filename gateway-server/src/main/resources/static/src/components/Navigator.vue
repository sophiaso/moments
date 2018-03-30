<template>
    <div>
        <b-navbar toggleable="md" type="dark" variant="info">
            <b-collapse is-nav id="nav_collapse" v-if="hasLoggedIn">
                <b-navbar-nav class="ml-auto">
                    <b-nav-item-dropdown right>
                        <template slot="button-content">
                            {{ username }}
                        </template>
                        <b-dropdown-item href="#" v-on:click="logout">Signout</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
            <b-navbar-nav class="ml-auto" v-else>
                <b-nav-item href="/login">Sign in</b-nav-item>
            </b-navbar-nav>
        </b-navbar>
    </div>
</template>
<script>
    import Vue from 'vue'
    import {Collapse, Nav, Navbar} from 'bootstrap-vue/es/components';

    Vue.use(Collapse);
    Vue.use(Nav);
    Vue.use(Navbar);

    export default {
        data: function() {
            return {
                username: 'user_1'
            }
        },
        methods: {
            logout: function() {
                this.username = '';
            }
        },
        computed: {
            hasLoggedIn: function() {
                return this.username && this.username.replace(/\s/g, '').length !== 0;
            }
        }
    };
</script>