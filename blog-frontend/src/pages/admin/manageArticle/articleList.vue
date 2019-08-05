<template>
  <div>
    <!-- <div v-for="item in articleList" class :key="item.id">
      <div @click="toLookArticle(item.id)">{{item.title}}</div>
    </div>-->
    <ul v-for="item in articleList" :key="item.id">
      <li>
        <span class="edit">
          <span @click="editArticle(item.id)">编辑</span>
          <span @click="deleteArticle(item.id)">删除</span>
        </span>
        <span class="time">{{new Date(item.create_by).toLocaleDateString()}}</span>
        <span class="title" @click="toLookArticle(item.id)">{{item.title}}</span>
      </li>
    </ul>
  </div>
</template>
<script>
import { getArchivesByDay } from "@/config/api";
import { deleteArticleById } from "@/config/api";
export default {
  data() {
    return {
      page: 1,
      pageSize: 10,
      articleList: [{ id: "2000", title: "学习最快乐" }]
    };
  },
  created() {
    this.getArchivesByDay();
  },
  mounted() {},
  methods: {
    getArchivesByDay() {
      this.$ajax({
        url: getArchivesByDay,
        method: "get"
      }).then(res => {
        if (res.status === 200) {
          this.articleList = res.data;
        } else {
          //报错
        }
      });
    },
    toLookArticle(id) {
      this.$router.push("/admin/lookArticle/" + id);
    },
    deleteArticle(id) {
      this.$ajax({
        url: deleteArticleById,
        method: "delete",
        params: {
          id: id
        }
      }).then(res => {
        if (res.status === 204) {
          // 删除成功
          this.getArchivesByDay();
        } else {
          //报错
        }
      });
    },
    editArticle(id) {
      this.$router.push("/admin/editArticle/" + id);
    }
  }
};
</script>
<style scoped>
li .title,
.edit span {
  margin-left: 2%;
  cursor: pointer;
}
.time {
  margin-left: 2%;
  color: #87819c;
}
li .title:hover,
.edit span:hover {
  color: #d42a2a;
}
</style>
