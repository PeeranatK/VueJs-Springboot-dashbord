<template>
    <div id="box" class="container mt-2 justify-content-center align-items-center">
    <div class="row justify-content-center">
      <div class="col-md ">
        <div class="card">
          <div class="card-header">Login</div>
          <div class="card-body">
            <form @submit.prevent="login">
              <div class="form-group">
                <label for="username">Username</label>
                <input type="text" v-model="username" class="form-control" id="username" required>
              </div>
              <div class="form-group">
                <label for="password">Password</label>
                <input type="password" v-model="password" class="form-control" id="password" required>
              </div>
              <button type="submit" class="btn btn-primary">Login</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
import Swal from 'sweetalert2';
import setHeader from '../utils/setHeader'
export default {
    data() {
      return {
        username: '',
        password: ''
      };
    },
    methods: {
        login() {
            // Add your login logic here
            console.log('Logging in...', this.username, this.password);
            axios.post('http://localhost:8081/api/getToken',{
                username: this.username,
                password: this.password
            })
            .then(response => {
                console.log('Token fetching :', response.data.token);
                console.log('Token2 fetching :', JSON.stringify(response.data.token));
                localStorage.setItem("token", JSON.stringify(response.data.token));
                setHeader(response.data.token);
                Swal.fire({
                    icon: 'success',
                    title: 'You are logging in!',
                });
                this.$router.push('/dashboard');
            })
            .catch(error => {
                console.error('Error fetching :', error);
                Swal.fire({
                    icon: 'error',
                    title: 'Username or password are wrong!',
                });
            });
            //localStorage.clear();

            // if (this.username === 't' && this.password ==='t') {
            //     Swal.fire({
            //         icon: 'success',
            //         title: 'You are logging in!',
            //     });
            //     this.$router.push('/dashboard');
            // } else {
            //     Swal.fire({
            //         icon: 'error',
            //         title: 'Username or password are wrong!',
            //     });
            // }
        }
      }
}
</script>

<style scoped>
#box{
    margin-left: 45%;
    margin-right: auto;
}
.btn{
    margin-top: 10%;
}
</style>