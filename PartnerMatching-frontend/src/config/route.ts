import Index from "../pages/Index.vue";
import TeamPage from "../pages/TeamPage.vue";
import SearchPage from "../pages/SearchPage.vue";
import UserPage from "../pages/UserPage.vue";
import UserEditPage from "../pages/UserEditPage.vue";
import UserLoginPage from "../pages/UserLoginPage.vue";
import SearchResultPage from "../pages/SearchResultPage.vue";
import TeamAddPage from "../pages/TeamAddPage.vue";
import TeamUpdatePage from "../pages/TeamUpdatePage.vue";
import UserUpdatePage from "../pages/UserUpdatePage.vue";
import UserTeamCreatePage from "../pages/UserTeamCreatePage.vue";
import UserTeamJoinPage from "../pages/UserTeamJoinPage.vue";

const routes = [
    {path: '/', component: Index},
    {path: '/team', component: TeamPage, title: "找队伍"},
    {path: '/team/add', component: TeamAddPage, title: "创建队伍"},
    {path: '/team/update', component: TeamUpdatePage, title: "更新队伍"},
    {path: '/user', component: UserPage, title: "用户信息"},
    {path: '/search', component: SearchPage, title: "找伙伴"},
    {path: '/user/edit', component: UserEditPage, title: "更新信息"},
    {path: '/user/list', component: SearchResultPage, title: "用户列表"},
    {path: '/user/login', component: UserLoginPage, title: "登录"},
    {path: '/user/update', component: UserUpdatePage, title: "更新信息"},
    {path: '/user/team/join', component: UserTeamJoinPage, title: "加入队伍"},
    {path: '/user/team/create', component: UserTeamCreatePage, title: "创建队伍"},
]

export default routes;