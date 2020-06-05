<template>
  <div id="main">
    <div class="justify-content-md-center">
      <div class="card" v-show="sumbitted">
        <div class="card-body">
          <form>
            <div class="form-group">
              <label for="exampleFormControlInput1">Email address</label>
              <input
                type="email"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="name@example.com"
                v-model="email"
              />
            </div>
            <div class="form-group">
              <label for="date">Date to pick up in market</label>
            </div>
            <input type="date" id="date" style="margin-bottom:10px;" />
            <div class="form-group">
              <label for="exampleFormControlTextarea1">Extra notes</label>
              <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
          </form>
          <button class="btn btn-primary" @click="Submit">Submit</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Buy",
  data() {
    return {
      id: 0,
      email: "",
      sumbitted: true
    };
  },
  methods: {
    Submit() {
      axios
        .post("http://localhost:8000/api/order/", {
          Sku: this.$route.params.id,
          numRequests: 1
        })
        .catch(function(error) {
          console.log(error);
        });
      console.log(this.email);
      this.sumbitted = false;
    },
    created() {
      this.id = this.$route.params.id;
    }
  }
};
</script>

<style>
#main {
  margin-top: 20px;
}
</style>