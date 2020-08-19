<template>
  <div>
    <div class="card,text-left">
      <div class="card-body">
        <div class="card-header" style="margin-bottom:5px">  
          <h5 class="text-left">{{Title}}</h5>
        </div>
          <div class="float-right" style ="margin-left:5px">
            <b-button variant="outline-primary" v-on:click= "show">{{this.message}}</b-button>
          </div>
        
        <h5 class="card-text" v-show="display">{{Description}}</h5>
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
    show:function() {
      this.display= !this.display
      if(this.display)
      {
        this.message = "Hide Description"
      }
      else{
        this.message = "Show Description"
      }
    }
  },
  data() {
    return{
    message: "Show Description",
    display: false
    };
  }
};
</script>

<style scoped>
</style>