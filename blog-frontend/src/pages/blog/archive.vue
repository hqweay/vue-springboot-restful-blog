<template>
  <div class="page">
    <ul class="listing">
      <!-- <li class="listing-seperator">2018</li> -->
      <li class="listing-item" v-for="item in archives" :key="item.id">
        <!-- .toDateString() -->
        <span class="time">{{new Date(item.create_by).toLocaleDateString()}}</span>
        <router-link :to="'/blog/article/'+item.id">{{item.title}}</router-link>
      </li>
    </ul>
  </div>
</template>

<script type="text/ecmascript-6">
import { getArchivesByDay } from "@/config/api";
export default {
  data() {
    return {
      archives: []
    };
  },
  created: function() {
    this.$ajax({
      url: getArchivesByDay,
      method: "get"
    }).then(res => {
      if (res.status === 200) {
        this.archives = res.data;
        console.log(res.data);
      } else {
        //报错
      }
    });
  },
  computed: {},
  methods: {
    getDate: function(str) {
      let date = new Date(str);
      return date.toLocaleDateString();
    }
  },
  components: {}
};
</script>

<style scoped lang="scss">
.page {
  a {
    text-decoration: none;
    padding: 0.2em 1em;
  }
  .listing {
    margin-top: 45px;
    list-style-type: none;
    li {
      line-height: 35px;
      list-style-type: none;
      font-size: 20px;
    }
    .listing-seperator {
      color: black;
    }
    .listing-item {
      font-size: 18px;
      span {
        color: #3e2727a6;
      }
      a {
        color: black;
      }
    }
  }
}
</style>
