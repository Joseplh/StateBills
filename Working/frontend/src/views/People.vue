<template>
  <div>
    <div class="card" style="width: 19rem;">
      <img class="card-img-top" :src="Image" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">{{Name}}</h5>
        <p class="card-text" v-show="expand">{{Description}}</p>
        <h6>{{Job}}</h6>
        <button class="btn btn-primary" @click="expand = true" v-show="!expand">See full Bio</button>
        <button class="btn btn-primary" @click="expand = false" v-show="expand">Hide Bio</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "person",
  props: {
    Name: String,
    Job: String,
    Description: String,
    Image: String
  },
  methods: {},
  data() {
    return {
      expand: false
    };
  }
};
</script>

<style scoped>
</style>