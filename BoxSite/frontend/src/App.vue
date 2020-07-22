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

export default {
  name: 'App',
  components: {
    ListItem
  },
  data() {
    return {
      
      bills: [
      { title: 'LB255A', description: 'Appropriation Bill' },
      { title: 'LB740', description: 'Revisor bill to repeal obsolete provisions relating to transfers of funds' },
      { title: 'LB741', description: 'Revisor bill to repeal obsolete provisions relating to the Subsidized Employment Pilot Program' },
      { title: 'LB742', description: 'Change penalty, sentencing, and hearing application provisions relating to offenses against animals' },
      { title: 'LB743', description: 'Adopt updated electrical standards' },
      { title: 'LB744', description: 'Authorize appointment of county engineer in certain counties and change powers and duties' },
      { title: 'LB745', description: 'Provide duties for law enforcement and prosecutors regarding federal immigration forms relating to victims of certain crimes' },
      { title: 'LB746', description: 'Adopt the Nebraska Consumer Data Privacy Act' },
      { title: 'LB7447', description: 'Change the definition of microbusiness under the Nebraska Advantage Microenterprise Tax Credit Act' }

    ]
    };
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
