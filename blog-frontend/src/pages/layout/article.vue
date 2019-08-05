<template>
  <div class="post">
    <div class="title">
      <h2>{{this.article.title}}</h2>
    </div>
    <div class="container">
      <div class="markdown-body">
        <div v-html="complileMarkdow" v-highlight></div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import marked from "marked";
// 引入样式
import "../../../node_modules/github-markdown-css/github-markdown.css";
let renderMd = new marked.Renderer();
marked.setOptions({
  renderer: renderMd,
  gfm: true,
  tables: true,
  breaks: false,
  pedantic: false,
  sanitize: false,
  smartLists: true,
  smartypants: false,
  // 可以自己选择引入样式 good
  highlight: function(code) {
    return require("highlight.js").highlightAuto(code).value;
  }
});

import { getArticleById } from "@/config/api";

export default {
  components: {},
  data() {
    return {
      article: {
        content: "加载中..."
      }
    };
  },
  computed: {
    complileMarkdow() {
      return marked(this.article.content, { sanitize: true });
    }
  },
  created: function() {
    this.$ajax({
      url: getArticleById,
      method: "get",
      params: {
        id: this.$route.params.id
      }
    }).then(res => {
      if (res.status === 200) {
        this.article = res.data;
      } else {
        //报错
      }
    });
  }
};
</script>

<style scoped >
.post .title {
  margin-top: 50px;
  text-align: center;
  font-size: 24;
}
/* 引入有效 */
/* @import "../../../node_modules/github-markdown-css/github-markdown.css"; */
</style>
