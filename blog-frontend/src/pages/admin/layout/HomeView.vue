<template>
  <el-container class="admin">
    <!-- <el-aside background-color="#99cccc"> -->
    <VSidebar @handleselect="handleselect" :collapse="collapse" :open="addOpen"></VSidebar>
    <!-- </el-aside> -->
    <el-container>
      <el-header class="top-header">
        <div class="menu-box">
          <div class="menu" @click="toggleMenu">菜单</div>
          <div class="welcome">
            <i class="el-icon-news"></i>

            <router-link to="/blog">回到博客首页</router-link>
            <!-- <div class="slogan">{{welcome}}</div> -->
          </div>
          <VHead/>
        </div>
      </el-header>
      <el-main>
        <!--展示的内容都这这个router-view-->
        <div class="main">
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import VHead from "./Header";
import VSidebar from "./SideBar";

export default {
  name: "Home",
  data() {
    return {
      collapse: false,
      addOpen: false,
      welcome: "哈罗~"
    };
  },
  components: {
    VHead,
    VSidebar
  },
  mounted() {},
  methods: {
    toggleMenu() {
      this.collapse = !this.collapse;
    },
    toggleoutin() {
      this.collapse = false;
      this.addOpen = !this.addOpen;
    },
    handleselect(val) {
      this.addOpen = val;
    }
  }
};
</script>

<style lang="less">
.admin {
  height: calc(100vh);
}
.main .post {
  width: 50%;
  margin: 0 auto;
}
.header {
  margin-top: 25px;
  // background-color: aqua;
}
.menu-box {
  height: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.welcome {
  color: black;
}
.welcome a {
  color: black;
  // font-size: 25px;
  text-decoration: none;
}
.menu {
  cursor: pointer;
  // background-color: #ccccff;
}
.side-bar {
  width: 50%;
}

.el-header,
.el-footer {
  background-color: #99cccc;
  color: #ffffff;
  line-height: 60px;
}

.el-aside {
  color: #333;
  text-align: center;
  background-color: rgb(84, 92, 100);
  min-height: 100%;
  overflow: hidden;
}

.menu1 {
  display: block;
  @media screen and (max-width: 500px) {
    display: none;
  }
}

.menu2 {
  display: none;
  @media screen and (max-width: 500px) {
    display: block;
  }
}

.el-main {
  background-color: #fff;
}
</style>
