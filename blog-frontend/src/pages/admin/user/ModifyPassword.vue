<template>
  <el-form
    :model="ruleForm2"
    :rules="rules2"
    ref="ruleForm2"
    label-position="left"
    label-width="0px"
    class="login-container"
  >
    <h3 class="title">改密码</h3>
    <el-form-item prop="userName">
      <el-input type="text" v-model="ruleForm2.userName" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="ruleForm2.password" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width:100%;">
      <el-button
        type="primary"
        style="width:100%;"
        @click.native.prevent="handleSubmit2"
        :loading="logining"
      >修改</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
// import {URI_LOGIN} from "../../const/uri";
export default {
  name: "Login",
  data() {
    return {
      logining: false,
      ruleForm2: {
        userName: "",
        password: ""
      },
      rules2: {
        userName: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
      },
      savePwd: true
    };
  },
  mounted() {},
  methods: {
    handleSubmit2() {
      this.$router.push("/admin/home");
    }
  }
};
</script>

<style scoped>
.login-container {
  -webkit-border-radius: 5px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.remember {
  margin: 0px 0px 35px 0px;
}
.registerBox {
  color: #c7c7c7;
}
.toRegister {
  text-decoration: none;
}
</style>
