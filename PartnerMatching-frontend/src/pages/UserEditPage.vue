<template>
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <van-field
          v-model="editUser.currentValue"
          :name="editUser.editKey"
          :label="editUser.editName"
          :placeholder="`请输入 + ${editUser.editKey}`"
          :rules="[{ required: true, message: '请填写用户名' }]"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import myAxios from "../plugins/myAxios.ts";
import {showFailToast, showSuccessToast} from "vant";
import {getCurrentUser} from "../service/user.ts";

const router = useRouter();
const route = useRoute();

const editUser = ref({
  editKey: route.query.editKey,
  currentValue: route.query.currentValue,
  editName: route.query.editName,
})

console.log(route.query);

const onSubmit = async () => {
  const currentUser = await getCurrentUser();
  if (!currentUser) {
    showFailToast("用户未登录");
    return;
  }
  
  const res = await myAxios.post("/user/update", {
    'id': 1,
    [editUser.value.editKey as string]: editUser.value.currentValue,
  })
  console.log(res, "更新请求")
  //修改成功返回上一个页面
  if (res.code === 0 && res.data > 0) {
    showSuccessToast("修改成功");
    router.back();
  } else {
    showFailToast("修改失败");
  }
}

</script>

<style scoped>

</style>