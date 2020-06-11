<template>
  <div>
    <div class="card" v-show="show">
      <div class="card-body">
        <h5 class="card-title">{{Title}}</h5>
        <p class="card-text" v-show="expand">{{Description}}</p>
        <button class="btn btn-primary" @click="expand = true" v-show="!expand">See full description</button>
        <button class="btn btn-primary" @click="expand = false" v-show="expand">Hide description</button>
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