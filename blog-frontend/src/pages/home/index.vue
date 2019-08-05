<template>
  <div class="page">
    <div class="home">
      <div class="name">{{ blog.name }}</div>
      <ul class="nav">
        <li class="item" v-for="item in this.$blog.home_nav" :key="item.name">
          <!-- <a :href="item.url">{{item.name}}</a> -->
          <router-link :to="item.url">{{item.name}}</router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      blog: this.$blog.site
    };
  },
  components: {}
};
</script>

<style scoped lang="scss">
.page {
  display: flex;
  justify-content: center;
  // width: 100%;
  // height: 100%;
  .home {
    position: absolute;
    top: 50%;
    width: 100%;
    height: 100%;
    height: 300px;
    margin-top: -150px;
    margin-bottom: 100px;
    text-align: center;
    .name {
      font-size: 33px;
      font-weight: bold;
      font-style: normal;
      line-height: 50px;
      height: 50px;
    }
    .nav {
      list-style-type: none;
      display: inline-flex;
      padding: 0;
      justify-content: space-between;
      .item {
        display: inline-block;
        margin-left: 1em;
        a {
          color: #d03535;
          //font-size: 14px;
          text-decoration: none;
          transition-duration: 0.5s;
        }
      }
    }
  }
}
</style>
