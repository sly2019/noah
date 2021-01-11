package com.sly.noah.core.modules.rbac.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Created by wj on 2021/1/4
 * @Description TODO
 */
@Data
public class RbacResourceVO {

    private Integer id;

    private Integer pid;

    private String name;

    private String uri;

    private String type;
    private String typeStr;

    private Integer rank;

    private String description;

    private Date createTime;
    private String createTimeStr;

    private Date lastUpdateTime;
    private String lastUpdateTimeStr;

}
