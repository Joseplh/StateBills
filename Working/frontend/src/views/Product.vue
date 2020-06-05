<template>
  <div>
    <div class="card" style="width: 18rem;" v-show="show">
      <img class="card-img-top" :src="Image" />
      <div class="card-body">
        <h5 class="card-title">{{Title}}</h5>
        <p class="card-text" v-show="expand">{{Description}}</p>
        <h6>${{Price}}</h6>
        <button class="btn btn-primary" @click="expand = true" v-show="!expand">See full description</button>
        <button class="btn btn-primary" @click="expand = false" v-show="expand">Hide description</button>
        <router-link
          :to="{ name: 'buy', params: { id: Sku } }"
          class="btn btn-primary"
          v-show="expand"
          style="margin-top: 10px;"
        >Reserve this Product</router-link>
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
    Image: String,
    Price: Number,
    Sku: Number
  },
  methods: {
    dele() {
      this.show = false;
      this.$emit("dele-sku", this.Sku);
    }
  },
  created() {
    this.Admin = this.$route.params.admin;
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