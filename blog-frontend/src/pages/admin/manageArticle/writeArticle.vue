<template>
  <div class="edit-article">
    <div class="title-box">
      <el-input class="info" v-model="article.title" :placeholder="info.title"></el-input>
      <el-input class="info" v-model="article.category" placeholder="category"></el-input>
      <el-input class="info" v-model="article.tag" placeholder="tag"></el-input>
    </div>

    <div class="editor-box">
      <mavon-editor style="height: 100%" v-model="article.content"></mavon-editor>
    </div>
    <div style="margin-top: 20px;">
      <el-button plain @click="submit" class="submit">发表</el-button>
    </div>
  </div>
</template>

<script>
import { createArticle } from "@/config/api";

export default {
  data() {
    return {
      info: {
        title: "请输入标题"
      },
      article: {
        title: "",
        category: "",
        tag: "",
        content: ""
      }
    };
  },
  methods: {
    notify(title, message, type) {
      this.$notify({
        title: title,
        message: message,
        type: type
      });
    },
    submit() {
      if (this.article.title && this.article.content) {
        this.$ajax({
          url: createArticle,
          method: "post",
          data: this.article
        }).then(res => {
          if (res.status === 201) {
            this.notify("成功", "添加成功", "success");
          } else {
            //报错
            this.notify("失败", "添加失败~", "warning");
          }
        });
      } else if (!this.article.title) {
        this.info.title = "标题不允许为空";
        this.notify("失败", "标题不允许为空", "warning");
      } else if (!this.article.content) {
        this.info.title = "内容不允许为空";
        this.notify("失败", "内容不允许为空", "warning");
      }
    }
  }
};
</script>
<style scoped>
.submit:hover {
  background-color: #ccffcc;
}
.submit:hover {
  color: black;
}
.editor-box {
  height: 700px;
}
.title-box {
  margin-bottom: 20px;
}
.info {
  margin-left: 1%;
  width: 30%;
}
</style>

