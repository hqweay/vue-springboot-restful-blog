<template>
  <div class="page">
    <transition name="fade" mode="out-in">
      <router-view/>
    </transition>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {};
  },
  components: {}
};
</script>

<style scoped lang="stylus">
body {
  margin: 0;
  padding: 0;
}
</style>
