package com.sly.noah.core.modules.rbac.controller;

import com.sly.noah.core.frontend.model.Result;
import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
@Controller
public class RbacResourceController {

    @Resource
    private RbacResourceService rbacResourceService;

    @RequestMapping("/rbacResource/test/count")
    @ResponseBody
    public Object countTest(){
        return rbacResourceService.count();
    }

    @RequestMapping("/rbacResource/test/select")
    @ResponseBody
    public Object selectTest(){
        return rbacResourceService.getById(1);
    }

    @RequestMapping("/rbacResource/manager")
    public String manager(Model model){
        return "core/rbac/resource/manager";
    }

    @RequestMapping("/rbacResource/dataList")
    @ResponseBody
    public Object dataList(){
        try {
            List<RbacResource> list = rbacResourceService.getAll();
            return Result.success(list, "ok");
        } catch (Exception e){
            e.printStackTrace();
        }
        return Result.failed("faild");
    }


}
