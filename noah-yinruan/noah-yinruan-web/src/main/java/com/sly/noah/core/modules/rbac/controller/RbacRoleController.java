package com.sly.noah.core.modules.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wj
 * @Date: 2021/1/24 15:50:14
 * @Description: TODO
 */
@Controller
public class RbacRoleController {

    @RequestMapping("/rbacRole/manager")
    public String manager(Model model){
        return "core/rbac/role/role_manager";
    }

}
