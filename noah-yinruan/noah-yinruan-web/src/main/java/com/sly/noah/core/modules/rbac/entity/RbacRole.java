package com.sly.noah.core.modules.rbac.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wj
 * @Date: 2021/1/24 15:15:00
 * @Description: TODO
 */
@Data
public class RbacRole {

    private Integer id;
    private String code;
    private String name;
    private Integer rank;
    private String description;
    private Date createTime;
    private Date lastUpdateTime;

}
