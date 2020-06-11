<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom:10px">
      <a class="navbar-brand">Nebraska State Legislature Bills</a>
    </nav>
    <div class="col-sm">
        <ul>
          <ListItem Title="Test"/>
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
      expand: false,
      show: true
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
