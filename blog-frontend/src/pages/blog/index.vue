<template>
  <div class="page">
    <mhead/>
    <!-- <marticle class="article"></marticle> -->
    <router-view/>
  </div>
</template>

<script type="text/ecmascript-6">
import mhead from "../layout/head.vue";
// import marticle from "../layout/article.vue";
export default {
  components: {
    mhead
    // marticle
  },
  data() {
    return {};
  }
};
</script>

<style scoped lang="scss">
.page {
  width: 640px;
  padding: 0;
  margin: 0 auto;
  // text-align: center;
  .article {
    margin: 0 auto;
  }
}
</style>
