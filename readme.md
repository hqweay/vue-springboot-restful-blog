# 后端

## 说明

一个前后端分离的博客项目的后端.

[在线演示](http://etob.hqweay.cn)

~~前端仓库 : [https://github.com/hqweay/blog-frontend](https://github.com/hqweay/blog-frontend)~~

## 参考

* RESTful API 参考 : [利用 Spring Boot 设计风格良好的Restful API及错误响应](https://www.jianshu.com/p/d6424d98b02e)
* shiro + jwt 做权限控制 : [集成JWT实现接口权限认证](https://www.xncoding.com/2017/07/09/spring/sb-jwt.html)

## 配置

* 逆向工程 : [https://github.com/hqweay/MyBatisGenerator-Tool](https://github.com/hqweay/MyBatisGenerator-Tool)
* springboot + gradle + 打包 Docker 配置 : 参考 [ 使用Gradle构建Docker镜像](<https://juejin.im/post/5b27b7ac51882574c32c6588>)
* swagger2 : api 管理与测试
* rabbitMQ 实现注册异步发送邮件 : [rabbitMQ 安装,基本操作,与 Spring Boot 整合](https://hqweay.cn/2019/05/23/rabbitMQ/)
* ...

## 其他

莫名其妙又成了折腾配置,实际没写啥...



# 前端

~~[在线演示](<http://etob.hqweay.cn/#/>)~~

~~后端项目 : [https://github.com/hqweay/blog-backend](https://github.com/hqweay/blog-backend)~~

一个博客的前端.

前后端分离,采取 RESTful API 风格交互数据(尽量),使用 jwt 方式进行权限控制(尽量).

## 引用

- 后台管理页面源于 [ https://gitee.com/linqinghu/blogAdmin]( https://gitee.com/linqinghu/blogAdmin)
- markdown 渲染插件 使用 marked
- markdown 渲染样式 使用 github-markdown-css
- markdown 文章编辑器 使用 mavon-editor
- ...

## TODO

- [ ] 权限控制
- [ ] 图片上传
- [ ] 移动端兼容
- [ ] ...

## 展示

### index

![index](https://github.com/hqweay/vue-springboot-restful-blog/blob/master/blog-frontend/screenshot/index.jpg?raw=true)

### article

![index](https://github.com/hqweay/vue-springboot-restful-blog/blob/master/blog-frontend/screenshot/article.jpg?raw=true)

### manage

![index](https://github.com/hqweay/vue-springboot-restful-blog/blob/master/blog-frontend/screenshot/manage.jpg?raw=true)

### editor

![index](https://github.com/hqweay/vue-springboot-restful-blog/blob/master/blog-frontend/screenshot/editor.jpg?raw=true)

## Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Run your tests

```
npm run test
```

### Lints and fixes files

```
npm run lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).