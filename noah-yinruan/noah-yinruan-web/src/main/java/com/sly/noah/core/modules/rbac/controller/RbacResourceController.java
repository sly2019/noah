package com.sly.noah.core.modules.rbac.controller;

import com.sly.noah.core.frontend.model.Result;
import com.sly.noah.core.modules.rbac.jpa.entity.RbacResource;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping("/rbac/resource/manager")
    public String manager(Model model){
        return "core/rbac/resource/resource_manager";
    }

    @RequestMapping("/rbac/resource/dataList")
    @ResponseBody
    public Object dataList(){
        try {
            Sort sort = Sort.by(Sort.Direction.ASC , "rank");
            List<RbacResource> list = rbacResourceService.getAll(null, sort);
            return Result.success(list, "获取数据成功");
        } catch (Exception e){
            e.printStackTrace();
        }
        return Result.failed("获取数据失败");
    }

    @RequestMapping("/rbac/resource/toAdd")
    public String toAdd(Model model, Integer pid){
        if(pid != null){
            RbacResource rbacResourceParent = rbacResourceService.getById(pid);
            model.addAttribute("rbacResourceParent", rbacResourceParent);
        }
        return "core/rbac/resource/resource_add";
    }

    @RequestMapping("/rbac/resource/add")
    @ResponseBody
    public Object add(RbacResourceVO vo) {
        try {
            //菜单uri唯一性判断
            if(StringUtils.isNotBlank(vo.getUri())){
                RbacResourceQueryBean queryBean = new RbacResourceQueryBean();
                queryBean.setUri(vo.getUri());
                long count = rbacResourceService.count(queryBean);
                if(count > 0){
                    return Result.failed("uri已存在");
                }
            }
            RbacResource rbacResource = rbacResourceService.convertVOToEntity(vo);
            if(vo.getPid() == null){
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

    @RequestMapping("/rbac/resource/toEdit")
    public String toEdit(Model model, Integer id){
        model.addAttribute("rbacResource", rbacResourceService.convertEntityToVO(rbacResourceService.getById(id)));
        return "core/rbac/resource/resource_edit";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/rbac/resource/delete")
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
