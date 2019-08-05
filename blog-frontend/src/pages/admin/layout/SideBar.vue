<template>
  <div class="sidebar" :class="{'open':open2}">
    <el-menu
      :default-active="onRoutes"
      class="el-menu-vertical-demo"
      unique-opened
      router
      @open="handleopen"
      @select="handleselect"
      background-color="#99cccc"
      text-color="FFFFFF"
      active-text-color="black"
      :collapse="collapse"
    >
      <!--<div style="height: 45px;text-align: center;line-height: 45px;color:#fff">云商后台</div>-->
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template slot="title">
              <i :class="item.icon"></i>
              <span slot="title">{{ item.title }}</span>
            </template>
            <el-menu-item
              v-for="(subItem,i) in item.subs"
              :key="i"
              :index="subItem.index"
            >{{ subItem.title }}</el-menu-item>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i>
            <span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
export default {
  props: {
    collapse: {
      type: Boolean,
      default: false
    },
    open: {
      type: Boolean,
      default: false
    }
  },
  watch: {
    open(value) {
      this.open2 = value;
    }
  },
  data() {
    return {
      open2: false,
      //侧边栏菜单
      items: [
        // {
        //   icon: "el-icon-mobile-phone",
        //   index: "/admin/home",
        //   title: "首页"
        // },
        {
          icon: "el-icon-tickets",
          index: "/admin/articleList",
          title: "所有博客"
        },
        {
          icon: "el-icon-edit-outline",
          index: "/admin/writeArticle",
          title: "编写博客"
        }

        // {
        //   icon: 'el-icon-mobile-phone',
        //   index: 'userCenter',
        //   title: '用户管理',
        //   subs: [
        //     {
        //       index: 'modifyPassword',
        //       title: '修改密码'
        //     }
        //   ]
        // }
      ]
    };
  },
  computed: {
    onRoutes() {
      // console.log(this.$route.path);
      return this.$route.path.replace("/", "");
    }
  },
  methods: {
    handleopen(key, keyPath) {
      // console.log(key);
      // console.log(keyPath);
    },
    handleselect(key, keyPath) {
      this.$router.push("/" + key);
      this.$emit("handleselect", false);
    }
  }
};
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>
<style lang="less" scoped>
.sidebar {
  padding: 0;
  border: 0;
  height: calc(100vh);
  transform: translateX(0);
  /*transition: transform 0.4s ease;*/
  @media screen and (max-width: 500px) {
    position: absolute;
    transform: translateX(-100%);
  }
  &.open {
    position: relative;
    transform: translateX(0);
    /*transition: transform 0.4s ease;*/
  }
}

.sidebar > ul {
  height: 100%;
}
</style>
