var mixins = {
    methods: {
        hasLoggedIn() {
            return this.$store.state.username && this.$store.state.username.replace(/\s/g, '').length !== 0;
        }
    }
}

export default mixins;