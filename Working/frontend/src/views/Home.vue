<template>
  <div class="home">
    <h1 style="margin-top:10px; margin-botton:10px">Rush Market TLC</h1>
    <div class="card">
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p
          class="text-justify"
        >This is Rush Market's TLC site. We at the the Rush Market are constantly hunting for fresh finds for our customers, and in the process, sometimes we buy products that are just in need of a little repair that might be beyond what the average person wants to takle. In order to keep our prices at the lowest possible point possible, we can't just take a financial loss on these products, so we post these products here. If you see something that you fancy, then simply click the reserve for market, and then select the date that you will be in the market to pick it up, and talk to a employee and ask to be taken to your product in the backroom. By selecting your product, we will place it in the staging room for you to come see, but if somebody else gets to it first, then we will sell it.</p>
        <router-link
          :to="{ name: 'list', params: { admin: false } }"
          class="btn btn-primary"
        >Check Out Our Products</router-link>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "home",
  components: {}
};
</script>
