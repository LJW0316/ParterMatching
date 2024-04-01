<template>
  <van-card
      v-for="team in teamList"
      :thumb="teamThumb"
      :desc="team.description"
      :title="team.name"
  >
    <template #tags>
      <van-tag plain type="danger" style="margin-right: 8px; margin-top: 8px">
        {{ teamStatusEnum[team.status] }}
      </van-tag>
    </template>
    <template #bottom>
      <div>
        {{ `队伍人数：${team.hasJoinNum} / ${team.maxNum}` }}
      </div>
      <div v-if="team.expireTime">
        {{ '过期时间：' + team.expireTime }}
      </div>
    </template>
    <template #footer>
      <van-button v-if="team.userId !== currentUser?.id && team.hasJoin == false" plain type="primary" size="mini"
                  @click="preJoinTeam(team)">加入队伍</van-button>
      <van-button v-if="team.userId === currentUser?.id" plain size="mini"
                  @click="doUpdateTeam(team.id)">更新队伍
      </van-button>
      <!--todo 仅加入的队伍可见-->
      <van-button v-if="team.userId !== currentUser?.id && team.hasJoin == true" plain size="mini"
                  @click="doQuitTeam(team.id)">退出队伍
      </van-button>
      <van-button v-if="team.userId === currentUser?.id" plain type="danger" size="mini"
                  @click="doDeleteTeam(team.id)">解散队伍
      </van-button>
    </template>
  </van-card>
  <van-dialog v-model:show="showPasswordDialog" title="请输入密码" show-cancel-button @confirm="doJoinTeam" @cancel="doJoinCancel">
    <van-field v-model="password" placeholder="请输入密码" />
  </van-dialog>
  <!--  {{currentUser}}-->
</template>
<script setup lang="ts">
import {TeamType} from "../models/team";
import {teamStatusEnum} from "../constants/team.ts";
import teamThumb from '../assets/team.png';
import myAxios from "../plugins/myAxios.ts";
import {showFailToast, showSuccessToast} from "vant";
import {getCurrentUser} from "../service/user.ts";
import {onMounted, ref} from "vue";
import {useRouter} from "vue-router";

interface TeamCardListProps {
  teamList: TeamType[];
}

const props = withDefaults(defineProps<TeamCardListProps>(), {
  // @ts-ignore
  teamList: [] as TeamType[],
})

const router = useRouter();

const currentUser = ref();

const joinTeamId = ref(0);
const showPasswordDialog = ref(false);
const password = ref('');

onMounted(async () => {
  currentUser.value = await getCurrentUser();
})

/**
 * 加入队伍
 * @param id 队伍id
 */
const doJoinTeam = async () => {
  const res = await myAxios.post("/team/join", {
    teamId: joinTeamId.value,
    password: password.value,
  });
  if (res.code === 0) {
    showSuccessToast("加入成功")
    doJoinCancel();
  } else {
    showFailToast("加入失败, " + (res.description ? `${res.description}` : ''));
  }
}

/**
 * 加入队伍前置函数
 * @param team
 */
const preJoinTeam = (team: TeamType) => {
  joinTeamId.value = team.id;
  if (team.status == 0) {
    doJoinTeam()
  } else {
    showPasswordDialog.value = true;
  }
}

const doJoinCancel = () => {
  joinTeamId.value = 0;
  password.value = '';
}

/**
 * 更新队伍，跳转至更新队伍页
 * @param id 队伍id
 */
const doUpdateTeam = (id: number) => {
  router.push({
    path: "/team/update",
    query: {
      id,
    }
  })
}

/**
 * 退出队伍
 * @param id
 */
const doQuitTeam = async (id: number) => {
  const res = await myAxios.post("/team/quit", {
    teamId: id,
  });
  if (res?.code === 0) {
    showSuccessToast("退出成功");
  } else {
    showFailToast("退出失败");
  }
}

/**
 * 解散队伍
 * @param id
 */
const doDeleteTeam = async (id: number) => {
  const res = await myAxios.post("/team/delete", {
    id: id,
  });
  if (res?.code === 0) {
    showSuccessToast("操作成功");
  } else {
    showFailToast("操作失败");
  }
}
</script>

<style scoped>

</style>