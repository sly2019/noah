package com.sly.noah.core.frontend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/1/13
 * @Description TODO
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LayuiMiniMenuTree extends BaseTree<LayuiMiniMenuTree> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String pid;
    private String name;
    private String title;
    private String field;
    private String code;
    private String description;
    private String icon;
    private String href;
    private String value;
    private boolean spread;
    private boolean selected;

    private List<LayuiMiniMenuTree> children = new ArrayList<>();

}
