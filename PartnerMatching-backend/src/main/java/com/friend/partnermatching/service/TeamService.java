package com.friend.partnermatching.service;

import com.friend.partnermatching.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.friend.partnermatching.model.domain.User;
import com.friend.partnermatching.model.dto.TeamQuery;
import com.friend.partnermatching.model.request.TeamJoinRequest;
import com.friend.partnermatching.model.request.TeamQuitRequest;
import com.friend.partnermatching.model.request.TeamUpdateRequest;
import com.friend.partnermatching.model.vo.TeamUserVo;

import java.util.List;

/**
* @author LJW
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-03-17 16:34:04
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     * @param team 创建的队伍
     * @param loginUser 登录的用户
     * @return 创建队伍的id
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery 搜索条件参数
     * @param isAdmin 是否是管理员
     * @return 队伍用户表
     */
    List<TeamUserVo> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest 更新内容
     * @param loginUser 登录用户信息
     * @return 更新是否成功
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest 加入队伍信息
     * @param loginUser 登录的用户
     * @return 加入是否成功
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest 退出队伍请求
     * @param loginUser 登录用户
     * @return 退出是否成功
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 解散队伍
     * @param teamId 解散队伍id
     * @param loginUser 登录用户
     * @return 解散是否成功
     */
    boolean deleteTeam(Long teamId, User loginUser);
}
