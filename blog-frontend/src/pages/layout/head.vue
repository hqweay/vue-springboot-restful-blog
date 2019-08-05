<template>
  <div class="page">
    <div class="header">
      <a href="/">禾七</a>
    </div>
    <div class="center">
      <ul>
        <li v-for="item in nav" :key="item.url">
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
      nav: this.$blog.blog_nav
    };
  },
  components: {}
};
</script>

<style scoped lang="scss">
.page {
  margin: 2em auto;
  display: block;
  padding: 0 2em;
  text-align: center;
  .header {
    margin-top: 40px;
    font-size: 40px;
    a {
      text-decoration: none;
      color: #ca8888;
    }
    a:hover {
      color: #d03535;
    }
  }
  .center {
    margin-top: 50px;
    ul {
      list-style: none;
      padding: 0;
      font-size: 20px;

      li {
        // margin-left: 2em;

        display: inline-block;
        a {
          border-top: 1px solid #ededed;
          border-bottom: 1px solid #ededed;
          padding: 10px 29px;
          color: #d03535;
          text-decoration: none;
        }
        a:hover {
          background-color: black;
          color: white;
        }
      }
    }
  }
}
</style>
