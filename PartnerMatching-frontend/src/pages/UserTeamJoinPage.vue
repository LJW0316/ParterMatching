<template>
  <div id="teamPage">
    <van-search v-model="searchText" placeholder="搜索队伍" @search="onSearch" />
    <TeamCardList :teamList="teamList" />
    <van-empty v-if="!teamList || teamList.length < 1" description="数据为空" />
  </div>
</template>

<script setup lang="ts">

import {useRouter} from "vue-router";
import TeamCardList from "../components/TeamCardList.vue";
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios.ts";
import {showFailToast} from "vant";

const router = useRouter();


const searchText = ref('');


const teamList = ref([]);

const listTeam = async (val = '') => {
  const res = await myAxios.get("/team/list/join", {
    params: {
      searchText: val,
    }
  });
  if (res.code === 0) {
    teamList.value = res.data;
  } else {
    showFailToast("加载队伍失败，请刷新重试");
  }
}

onMounted(() => {
  listTeam();
})

const onSearch = (val) => {
  listTeam(val);
}
</script>

<style scoped>
</style>