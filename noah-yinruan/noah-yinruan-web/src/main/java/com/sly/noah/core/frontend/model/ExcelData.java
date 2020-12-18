package com.sly.noah.core.frontend.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname ExcelData
 * @Created by wangjian
 * @Date 2020/2/26 13:51
 * @Description excel数据模型
 */

@Data
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4454016249210520899L;

    /**
     * 表头
     */
    private List<String> titles;

    /**
     * 数据
     */
    private List<List<Object>> rows;

    /**
     * 页签名称
     */
    private String name;

}
