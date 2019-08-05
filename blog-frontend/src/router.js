import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import(/* webpackChunkName: "about" */ './pages/home/index.vue')
    },
    {
      path: '/blog',
      name: 'blog',
      component: () => import('./pages/blog/index.vue'),
      children: [
        {
          path: '/blog/',
          component: () => import('./pages/blog/archive.vue'),
        },
        {
          path: '/blog/archive',
          component: () => import('./pages/blog/archive.vue')
        },
        {
          path: '/blog/article/:id',

          component: () => import('./pages/layout/article.vue')
        },
        {
          path: '/blog/category',

          component: () => import('./pages/blog/category.vue')
        },
        {
          path: '/blog/tag',
          component: () => import('./pages/blog/tag.vue')
        }
      ]
    },
    {
      path: '/admin', redirect: '/admin/login',
      component: () => import('./pages/admin/index.vue'),

      children: [
        {
          path: '/admin/login',
          component: () => import('./pages/admin/user/Login.vue') //import('./pages/admin/user/Login.vue')
        }, {
          path: '/admin/home',
          component: () => import('./pages/admin/layout/HomeView.vue'),
          meta: {
            requireAuth: true,
            // wrapper: true
          },
          children: [
            {
              path: '/admin/home',
              component: () => import('./pages/admin/manageArticle/articleList.vue'),
            },
            {
              path: '/admin/writeArticle',
              component: () => import('./pages/admin/manageArticle/writeArticle.vue'),
            }, {
              path: '/admin/editArticle/:id',
              component: () => import('./pages/admin/manageArticle/editorArticle.vue'),

            }, {
              path: '/admin/articleList',
              component: () => import('./pages/admin/manageArticle/articleList.vue'),
            }, {
              path: '/admin/lookArticle/:id',
              // component: () => import('./pages/admin/articleManage/lookArticle.vue'),
              component: () => import('./pages/layout/article.vue')
            }, {
              path: '/admin/modifyPassword',
              component: () => import('./pages/admin/user/ModifyPassword.vue')
            },
          ]
        }, {
          path: '/admin/test',
          // component: () => import('./components/common/HomeView.vue'),
        },
      ]

    }
  ]
})


// admin filter
router.beforeEach((to, from, next) => {
  // https://router.vuejs.org/zh/guide/advanced/meta.html
  if (to.matched.some(res => res.meta.requireAuth)) {// 判断是否需要登录权限 路由可能嵌套 故循环判断
    if (!this.$cookieStore.getCookie("token")) {
      next();
    } else {
      next({
        path: '/blog/admin/login',
        query: { redirect: to.fullPath }
      });
    }
  } else {
    next()
  }
});

export default router
