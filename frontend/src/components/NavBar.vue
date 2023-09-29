<template>
    <div>
        <nav class="navbar navbar-fixed-top bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand">Navbar</a>
                <button class="btn btn-outline-success" @click="logout">logout</button>
            </div>
        </nav>
    </div>
</template>
<script>
export default {
    methods: {
        logout() {
            localStorage.clear();
            this.$router.push('/');
        }
      }
}
</script>
<style scoped>
.navbar {
  position: fixed;
  width: 80%;
  top: 0;
  z-index: 999; /* Adjust the z-index value as needed */
}
</style>