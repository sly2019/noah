package com.sly.noah.core.modules.rbac.controller;

import com.sly.noah.core.modules.rbac.service.RbacTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Created by wj on 2021/2/21
 * @Description: TODO
 */
@Controller
public class RbacTeamController {

    @Resource
    private RbacTeamService rbacTeamService;

    @RequestMapping("/rbac/team/manager")
    public String manager(Model model){
        return "core/rbac/team/team_manager";
    }


}
