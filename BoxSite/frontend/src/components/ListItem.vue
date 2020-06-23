<template>
  <div>
    <div class="card,text-left">
      <div class="card-body">
        <div class="card-header">  
        <h3 class="text-left">{{Title}}</h3>
        </div>
        <p class="card-text" >{{Description}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Product",
  props: {
    Title: String,
    Description: String,
  },
  methods: {
    dele() {
      this.show = false;
    }
  },
  data() {
    return {
      expand: false,
      show: true
    };
  }
};
</script>

<style scoped>
</style>