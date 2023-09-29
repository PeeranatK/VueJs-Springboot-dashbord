<!-- eslint-disable vue/no-unused-components -->

<template>
    <div class="container">
        <div class="row">
        
        <div >
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th v-for="field in fields" :key="field">{{ field }}</th>
                        <th></th> <!-- Empty column for buttons -->
                        <th></th> <!-- Empty column for buttons -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="item in items" :key="item.id">
                        <td v-for="field in fields" :key="field">{{ item[field] }}</td>
                        <td><button class="btn btn-primary" @click="editItem(item)">Edit</button></td>
                        <td><button class="btn btn-secondary" @click="deleteItem(item.id)">Delete</button></td>
                    </tr>
                </tbody>
                
                <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">User Information</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" @click="closeModal"></button>
                        </div>
                        <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" v-model="modalData.username" class="form-control" id="username" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" v-model="modalData.password" class="form-control" id="password" required>
                            </div>
                            <div class="form-group">
                                <label for="value">Value</label>
                                <input type="text" v-model="modalData.value" class="form-control" id="value">
                            </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" @click="closeModal">Close</button>
                        <button type="button" class="btn btn-primary" @click="save">Save</button>
                        </div>
                    </div>
                    </div>
                </div>
            </table>
        </div>
        
        </div>
    </div>
    
  </template>
  
<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
    
    data() {
        return {
            modalData: {
                id: '',
                username: '',
                password: '',
                value: ''
            },    
            fields: ['id', 'username', 'password', 'value', 'roles'],
            items: []
        }
    },
    methods: {
        fetchData() {
            axios.get('http://localhost:8081/api/getAllQuery')
                .then(response => {
                this.items = response.data;
                })
                .catch(error => {
                console.error('Error fetching data:', error);
                });
        },
        editItem(item){
            console.log(item.id);
            this.modalData.id = item.id; 
            this.modalData.username = item.username; 
            this.modalData.password = item.password; 
            this.modalData.value = item.value;
            //console.log(this.modalData.username);
            const modal = document.getElementById('editModal');
            modal.classList.add('show');
            modal.style.display = 'block';
        },
        closeModal() {
            // Hide the modal without jQuery
            const modal = document.getElementById('editModal');
            modal.classList.remove('show');
            modal.style.display = 'none';
        },
        save() {
            console.log("save");
            
            axios.post('http://localhost:8081/api/updateUser',{
                id: this.modalData.id,
                username: this.modalData.username,
                password: this.modalData.password,
                value: this.modalData.value
            })
            .then(response => {
                console.log(response);
                Swal.fire({
                    icon: 'success'
                });
                this.fetchData();
            })
            .catch(error => {
                console.error('Error fetching :', error);
                Swal.fire({
                    icon: 'error'
                });
            });
            this.closeModal();
        },
        deleteItem(id){
            console.log(id);
            axios.post('http://localhost:8081/api/deleteUser',{
                id: id,
            })
            .then(response => {
                console.log(response);
                Swal.fire({
                    icon: 'success'
                });
                this.fetchData();
            })
            .catch(error => {
                console.error('Error fetching :', error);
                Swal.fire({
                    icon: 'error'
                });
            });
        }
    },
    created() {
        this.fetchData(); // Call the method to fetch data when the component is created
    },
    
}
</script>
<style scoped>
.container{
    width: 200%;
    border-style: solid;
}
.row{
    align-self: center;
}
</style>