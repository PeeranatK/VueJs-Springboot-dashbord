<script setup>
    import TableList from '../components/TableList.vue';
    import Navbar from '../components/NavBar.vue';
</script>
<template>
  <Navbar />
  <div class="top-table">
    <span class="text">User Information</span>
    <button id="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Add User</button>
  </div>
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">User Information</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
              <div class="form-group">
                <label for="username">Username</label>
                <input type="text" v-model="username" class="form-control" id="username" required>
              </div>
              <div class="form-group">
                <label for="password">Password</label>
                <input type="password" v-model="password" class="form-control" id="password" required>
              </div>
              <div class="form-group">
                <label for="value">Value</label>
                <input type="password" v-model="value" class="form-control" id="value">
              </div>
            </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary" @click="save">Save</button>
        </div>
      </div>
    </div>
  </div>
  <TableList />
</template>

<script>
import axios from 'axios';
import Swal from 'sweetalert2';
export default {
    data() {
      return {
        username: '',
        password: '',
        value: ''
      };
    },
    methods: {
        save() {
            axios.post('http://localhost:8081/api/addUser',{
                username: this.username,
                password: this.password,
                value: this.value
            })
            .then(response => {
                console.log(response);
                Swal.fire({
                    icon: 'success'
                });
            })
            .catch(error => {
                console.error('Error fetching :', error);
                Swal.fire({
                    icon: 'error'
                });
            });
        }
      }
}
</script>

<style>

.top-table{
  margin-bottom: 2%;
  width: 60%;
}
.text{
  margin-right: 100%;
  font-weight: 1000;
}
</style>