<template>
  <div class="header">
    <el-dropdown trigger="hover" @command="handleCommand">
      <span class="el-dropdown-link user">
        <img class="user-logo" src="@/assets/logo.png">
        <span class="username">{{userName}}</span>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="updatePassword">修改密码</el-dropdown-item>
        <el-dropdown-item command="loginout">退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userName: "Hqweay"
    };
  },
  created() {
    if (sessionStorage.getItem("myUserName")) {
      this.userName = sessionStorage.getItem("myUserName");
    } else {
      // 权限判断
      // this.$router.push('/login');
    }
  },
  computed: {
    username() {
      let username = sessionStorage.getItem("myUserName");
      return username ? username : this.name;
    }
  },
  methods: {
    handleCommand(command) {
      if (command == "loginout") {
        this.$confirm("确定退出登录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            sessionStorage.removeItem("myUserName");
            sessionStorage.removeItem("myUserId");
            sessionStorage.removeItem("myAccessToken");
            this.$message({
              type: "success",
              message: "退出成功!"
            });
            this.$router.push("/login");
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消退出"
            });
          });
      } else if (command == "updatePassword") {
        this.$router.push("/admin/modifyPassword");
      }
    }
  }
};
</script>
<style scoped>
.el-dropdown-link {
  cursor: pointer;
}

.user-logo {
  width: 50px;
  height: 50px;
}
/* .el-dropdown-link {
  display: flex;
} */
.user {
  display: flex;
}
.username {
  margin-left: 7%;
  color: black;
}
</style>
