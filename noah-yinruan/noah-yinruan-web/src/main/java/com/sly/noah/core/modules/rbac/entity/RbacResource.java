package com.sly.noah.core.modules.rbac.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Created by wj on 2020/12/13
 * @Description TODO
 */
@Data
public class RbacResource {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源uri/权限标识
     */
    private String uri;

    /**
     * 资源类型：1 目录，2 板块，3 菜单，4 按钮
     */
    private String type;

    /**
     * 排序号
     */
    private String rank;

    /**
     * 说明
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;

}
