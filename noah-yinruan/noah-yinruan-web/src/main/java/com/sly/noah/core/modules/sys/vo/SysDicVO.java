package com.sly.noah.core.modules.sys.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
@Data
public class SysDicVO {

    private Integer id;

    private Integer pid;

    private String name;

    private String code;

    private Integer rank;

    private String description;

    private Date createTime;
    private String createTimeStr;

    private Date lastUpdateTime;
    private String lastUpdateTimeStr;
}
