 <template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom:10px">
      <a class="navbar-brand" href="#">
        <img
          data-v-ccc41290
          src="//cdn.shopify.com/s/files/1/1757/1461/files/HZ-no-city-digital-black.png?10146406607426040436"
          alt="The Rush Market"
          width="250"
        />
      </a>
      <div>
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link to="/" class="nav-link">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link :to="{ name: 'about', params: { admin: false } }" class="nav-link">About Us</router-link>
          </li>
          <li class="nav-item">
            <router-link
              :to="{ name: 'list', params: { admin: false } }"
              class="nav-link"
            >Our Products</router-link>
          </li>
        </ul>
      </div>
    </nav>
    <router-view />
  </div>
</template>


<script>
export default {
  name: "app",
  components: {},
  data() {
    return {
      admin: false
    };
  },
  methods: {}
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>