package com.friend.partnermatching.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = -2476789757832416433L;

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;


}
