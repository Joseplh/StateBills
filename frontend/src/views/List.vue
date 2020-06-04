<template>
  <div class="container">
    <div class="row">
      <div class="col-sm">
        <ul></ul>
      </div>
      <div class="col-sm">
        <ul v-for="item in products.objects" :key="item.description">
          <product
            :Title="item.title"
            :Description="item.description"
            :Image="item.picture"
            :Price="item.price"
            :Sku="item.id"
          ></product>
        </ul>
      </div>
      <div class="col-sm">
        <ul></ul>
      </div>
    </div>
  </div>
</template>

<script>
import Product from "./Product.vue";
import axios from "axios";
export default {
  name: "List",
  components: {
    Product
  },
  methods: {
    submit() {}
  },
  data() {
    return {
      inputTitle: "",
      inputPrice: 0,
      inputLink: "",
      inputDescription: "",
      admin: this.$route.params.admin,
      products: [
        {
          temp: 0
        }
      ]
    };
  },
  created() {
    axios.get("http://localhost:8000/api/product/").then(response => {
      this.products = response.data;
    });
  }
};
</script>

<style scoped>
</style>
