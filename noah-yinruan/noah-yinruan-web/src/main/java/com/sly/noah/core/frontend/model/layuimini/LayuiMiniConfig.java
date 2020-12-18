package com.sly.noah.core.frontend.model.layuimini;

import lombok.Data;

import java.util.List;

/**
 * @Created by wj
 * @Date 2020/8/16 19:45
 * @Description TODO
 */
@Data
public class LayuiMiniConfig {

    private LayuiMiniMenu homeInfo;

    private LayuiMiniMenu logoInfo;

    private List<LayuiMiniMenu> menuInfo;

}
