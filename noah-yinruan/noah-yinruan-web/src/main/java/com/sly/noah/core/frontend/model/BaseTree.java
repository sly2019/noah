package com.sly.noah.core.frontend.model;

import lombok.Data;

/**
 * @NAME: BaseTree
 * @Auther: sly
 * @Date: 2019/11/27 13:06
 * @Description: 基本树模型
 */
@Data
public class BaseTree<T> {

    private String id;
    private String pid;
    private String name;
    private Boolean isOpen;
    private T data;

}
