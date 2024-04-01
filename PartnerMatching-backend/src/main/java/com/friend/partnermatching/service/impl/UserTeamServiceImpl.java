package com.friend.partnermatching.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.friend.partnermatching.model.domain.UserTeam;
import com.friend.partnermatching.mapper.UserTeamMapper;
import com.friend.partnermatching.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author LJW
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-03-17 16:35:09
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




