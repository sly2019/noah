package com.sly.noah.core.modules.rbac.controller;

import com.sly.noah.core.frontend.model.Result;
import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
@Controller
public class RbacResourceController {

    @Resource
    private RbacResourceService rbacResourceService;

    @RequestMapping("/rbacResource/manager")
    public String manager(Model model){
        return "core/rbac/resource/manager";
    }

    @RequestMapping("/rbacResource/toAdd")
    public String toAdd(Model model, Integer pid){
        if(pid != null){
            RbacResource rbacResourceParent = rbacResourceService.getById(pid);
            model.addAttribute("rbacResourceParent", rbacResourceParent);
        }
        return "core/rbac/resource/add";
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

    @RequestMapping("/rbacResource/add")
    @ResponseBody
    public Object add(RbacResourceVO rbacResourceVO) {
        try {
            RbacResource rbacResource = rbacResourceService.convertVOToEntity(rbacResourceVO);
            if(rbacResourceVO.getPid() == null){
                rbacResource.setPid(-1);
            }
            rbacResource.setCreateTime(new Date());
            rbacResourceService.save(rbacResource);
            return Result.success(null, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("添加失败！\n" + e.getMessage());
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/rbacResource/delete")
    @ResponseBody
    @Transactional
    public Object delete(Integer id) {
        try {
            rbacResourceService.deleteWithAllSubById(id);
            return Result.success(null, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("删除失败！\n" + e.getMessage());
        }
    }



}
