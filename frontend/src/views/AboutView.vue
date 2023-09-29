<template>
  <div class="about">
    <h1>This is an about page test</h1>
    <button @click="onClickRef">Ref : {{counterRef}}</button>  
    <button @click="onClickRt">Reactive : {{counterRt.counter}}</button>  
    <ul>
      <li v-for="book in books" :key="book.id">
        {{ book.title }} by {{ book.author }}
      </li>
    </ul>
    <h1>This is an about page test</h1>
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.username }} by {{ user.password }}
      </li>
    </ul>
  </div>
</template>

<script>
  import axios from 'axios';
  import useCounter from "../services/test"
  export default {
    setup(){
      const {counterRef, onClickRef} = useCounter.useCounterRef(0)
      const {counterRt, onClickRt} = useCounter.useCounterRt(0)

      return {counterRef, onClickRef, counterRt, onClickRt}
    },
    data() {
      return {
        books: []
      };
    },
    mounted() {
      axios.get('http://localhost:8081/hello')
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.error('Error fetching books:', error);
        });
      axios.get('http://localhost:8081/Test')
        .then(response => {
          this.users = response.data;
        })
        .catch(error => {
          console.error('Error fetching user:', error);
        });
    }
}
</script>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
