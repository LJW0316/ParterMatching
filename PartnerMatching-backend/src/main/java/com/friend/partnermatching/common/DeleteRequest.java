package com.friend.partnermatching.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求
 */
@Data
public class DeleteRequest implements Serializable {
    private static final long serialVersionUID = 4677757934630064429L;

    private long id;

}
