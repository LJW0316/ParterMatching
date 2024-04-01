<template>
  <van-cell center title="心动模式">
    <template #right-icon>
      <van-switch v-model="isMatchMode" size="24"/>
    </template>
  </van-cell>
  <UserCardList :user-list="userList" :loading="loading"/>
  <van-empty v-if="!userList || userList.length < 1" description="数据为空"/>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import {onMounted, ref, watchEffect} from "vue";
import myAxios from "../plugins/myAxios.js";
import qs from 'qs';
import UserCardList from "../components/UserCardList.vue";

const route = useRoute()

const {tags} = route.query;

// type ModeType = "default" | "match";
const isMatchMode = ref<boolean>(false);

const userList = ref([])
const loading = ref(true);

const loadData = async () => {
  loading.value = true;
  let userListData = [];
  if (!isMatchMode.value) {
    //普通模式
    userListData = await myAxios.get('/user/recommend', {
      params: {
        pageSize: 8,
        pageNum: 1,
      },
      paramsSerializer: params => {
        return qs.stringify(params, {indices: false})
      }
    }).then(function (response) {
      console.log('/user/recommend succeed', response)
      return response?.data?.records;
    })
        .catch(function (error) {
          console.error('/user/recommend error', error);
        })
  } else {
    //心动模式
    const num = 10;
    userListData = await myAxios.get('/user/match', {
      params: {
        num,
      },
      paramsSerializer: params => {
        return qs.stringify(params, {indices: false})
      }
    }).then(function (response) {
      console.log('/user/match succeed', response)
      return response?.data;
    })
        .catch(function (error) {
          console.error('/user/match error', error);
        })
  }
  if (userListData) {
    userListData.forEach(user => {
      if (user.tags) {
        user.tags = JSON.parse(user.tags);
      }
    })
    userList.value = userListData;
  }
  loading.value = false;
}

watchEffect(() => {
  // console.log(isMatchMode.value);
  loadData();
})

</script>

<style scoped>
</style>