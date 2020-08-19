<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom:10px">
      <h1 class="navbar-brand">Nebraska State Legislature Bills</h1>
    </nav>



    <form>
   <div class="form-row" style="margin-left:75px">
    <div class="form-group col-7">
      <input type="text" class="form-control" id="Search" placeholder="Search" v-model="query">
    </div>
    <div class="form-group col">
      <select class="form-control" v-model="choice">
        <option selected value = "-">All Years</option>
        <option>2020</option>
        <option>2019</option>
        <option>2018</option>
        <option>2017</option>
        <option>2016</option>
        <option>2015</option>
        <option>2014</option>
        <option>2013</option>
        <option>2012</option>
        <option>2011</option>
        <option>2010</option>
        <option>2009</option>
        <option>2008</option>
        <option>2007</option>
      </select>
    </div>  
    <div class="form-group col">
      <button type="button" class="btn btn-primary" v-on:click= "searchBills">Search</button>
    </div>
  </div>
</form>


    
    <div class="col-sm">
        <ul>
          <ListItem v-for="item in bills.recordset" :key="item.DocumentID" :Title="item.Document" :Description="item.Description"/>
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
        {Description: 'Description', Document: 'Document', DocumentID:'id', Status:"Final Reading", Date: '1-1-12'},
      ],
      choice: '-',
      query: '',
      temp:[]
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

    },
    searchBills(){

      var i;
      var count = 0;
      console.log("Searching");
      console.log(this.bills.recordset.length);
      for (i = 0; i < this.bills.recordset.length; i++) {
          console.log('1');
      if(this.bills.recordset[i].Description.includes(this.query)&&this.bills.recordset[i].Update_date.includes(this.choice))
      {
        this.temp[count]=this.bills.recordset[i];
        count ++;
      
      }
      
        


      }
      this.bills.recordset = this.temp;
      console.log("Done");

    }

  },
  created(){
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
