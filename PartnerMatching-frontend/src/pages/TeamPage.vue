<template>
  <div id="teamPage">
    <van-search v-model="searchText" placeholder="搜索队伍" @search="onSearch" />
    <van-tabs v-model:active="active" @change="onTabChange">
      <van-tab title="公开" name="public"/>
      <van-tab title="加密" name="private"/>
    </van-tabs>

    <TeamCardList :teamList="teamList" />
    <van-button class="add-button" type="primary" icon="plus" @click="toAddTeam" />
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
const active = ref('public')

/**
 * 切换标签页
 * @param name
 */
const onTabChange = (name) => {
  if (name === 'public') {
    listTeam(searchText.value, 0);
  } else {
    listTeam(searchText.value, 2);
  }
}

//跳转到创建队伍页
const toAddTeam = () => {
  router.push({
    path: "/team/add"
  })
}

const teamList = ref([]);

/**
 * 搜索队伍
 * @param val
 * @param status
 */
const listTeam = async (val = '', status = 0) => {
  const res = await myAxios.get("/team/list", {
    params: {
      searchText: val,
      status: status,
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