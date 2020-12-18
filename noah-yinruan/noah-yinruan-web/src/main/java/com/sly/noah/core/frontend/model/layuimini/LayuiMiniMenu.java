package com.sly.noah.core.frontend.model.layuimini;

import lombok.Data;

import java.util.List;

/**
 * @Created by wj
 * @Date 2020/8/16 19:47
 * @Description TODO
 */
@Data
public class LayuiMiniMenu {

    private String title;
    private String image;
    private String href;
    private String target;

    private List<LayuiMiniMenu> child;

}
