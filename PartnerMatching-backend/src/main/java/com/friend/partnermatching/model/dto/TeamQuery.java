package com.friend.partnermatching.model.dto;

import com.friend.partnermatching.common.PageRequest;
import lombok.Data;

import java.util.List;

/**
 * 队伍查询封装类
 */
@Data
public class TeamQuery extends PageRequest {
    /**
     * id
     */
    private Long id;

    /**
     * id列表
     */
    private List<Long> idList;

    /**
     * 搜索关键词（同时根据队伍名称和描述搜索）
     */
    private String searchText;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;


    /**
     * 用户id（队长 id）
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

}
