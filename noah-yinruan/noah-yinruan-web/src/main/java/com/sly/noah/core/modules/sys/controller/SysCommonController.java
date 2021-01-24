package com.sly.noah.core.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wj
 * @Date: 2021/1/19 22:09:58
 * @Description: TODO
 */
@Controller
public class SysCommonController {

    @RequestMapping("/sys/common/icon")
    public String icon(){
        return "core/sys/common/icon";
    }

}
