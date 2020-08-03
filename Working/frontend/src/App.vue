<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom:10px">
      <h1 class="navbar-brand">Nebraska State Legislature Bills</h1>
    </nav>
    <div class="col-sm">
        <ul>
          <ListItem v-for="item in bills" :key="item" :Title="item.title" :Description="item.description"/>
        </ul>
      </div>
  </div>
</template>

<script>
import ListItem from './components/ListItem.vue'
import service from './services/billsService.js'

export default {
  name: 'App',
  props: {
    info: String
  },
  components: {
    ListItem
  },
  data() {
    return {
      
      bills: [
      { title: 'Loading', description: 'Loading' }
    ]
    };
  },
  methods:{
    async getBills(){
      service.getBills().then(
        (response=>{
          console.log(response);
          this.$set(this, 'bills', response.data);
        }).bind(this)
      )

    }
  },
  mounted(){
    this.getBills();
  }
 
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 00px;
}
</style>
