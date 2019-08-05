<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <!-- <home/> -->
    <router-view/>
  </div>
</template>

<script>
// import home from "./pages/home/home.vue";

export default {
  name: "app",
  components: {
    // home
  }
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}
#app {
  /* display: flex;
  justify-content: center; */
  /* align-items: center; */
  /* margin-top: 3%; */
}
</style>
