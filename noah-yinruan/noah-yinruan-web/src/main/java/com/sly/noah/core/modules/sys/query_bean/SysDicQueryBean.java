package com.sly.noah.core.modules.sys.query_bean;

import lombok.Data;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
@Data
public class SysDicQueryBean {

    private Integer id;
    private Integer[] idIsNotIn;

    private String code;

    private Integer pid;

}
