package com.friend.partnermatching.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求
 */
@Data
public class TeamQuitRequest implements Serializable {
    private static final long serialVersionUID = 1028327025247733673L;

    /**
     * 队伍id
     */
    private Long teamId;
}
