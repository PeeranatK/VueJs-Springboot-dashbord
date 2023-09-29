<!-- eslint-disable vue/no-mutating-props -->
<template>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Modal Title</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <!-- Form with input fields -->
            <form>
              <div class="mb-3">
                <label for="inputField" class="form-label">Input Field</label>
                <input type="text" class="form-control" v-model="formData.inputField">
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" @click="saveChanges">Save changes</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      formData: {
        type: Object,
        required: true
      }
    },
    methods: {
      saveChanges() {
        // Perform any actions needed to save the changes
        // For example, you can emit an event to notify the parent component
        // that changes have been made and close the modal
        this.$emit('save', this.formData);
        this.$refs.modalElement.hide(); // Assuming you're using Bootstrap 5
      }
    }
  };
  </script>
  