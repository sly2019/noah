package com.sly.noah.core.modules.sys.controller;

import com.sly.noah.core.frontend.model.Result;
import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
import com.sly.noah.core.modules.sys.service.SysDicService;
import com.sly.noah.core.modules.sys.vo.SysDicVO;
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
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
@Controller
public class SysDicController {

    @Resource
    private SysDicService sysDicService;

    @RequestMapping("/sys/dic/manager")
    public String manager(Model model){
        return "core/sys/dic/dic_manager";
    }

    @RequestMapping("/sys/dic/dataList")
    @ResponseBody
    public Object dataList(){
        try {
            List<SysDic> list = sysDicService.getAll(null);
            return Result.success(list, "获取数据成功");
        } catch (Exception e){
            e.printStackTrace();
        }
        return Result.failed("获取数据失败");
    }

    @RequestMapping("/sys/dic/toAdd")
    public String toAdd(Model model, Integer pid){
        model.addAttribute("pid", pid);
        return "core/sys/dic/dic_add";
    }

    @RequestMapping("/sys/dic/add")
    @ResponseBody
    public Object add(SysDicVO vo) {
        try {
            //菜单uri唯一性判断
            if(StringUtils.isNotBlank(vo.getCode())){
                SysDicQueryBean queryBean = new SysDicQueryBean();
                queryBean.setCode(vo.getCode());
                queryBean.setPid(vo.getPid());
                long count = sysDicService.count(queryBean);
                if(count > 0){
                    return Result.failed("编码已存在");
                }
            }
            SysDic sysDic = sysDicService.convertVOToEntity(vo);
            if(vo.getPid() == null){
                sysDic.setPid(-1);
            }
            sysDic.setCreateTime(new Date());
            sysDicService.save(sysDic);
            return Result.success(null, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("添加失败！\n" + e.getMessage());
        }
    }

    @RequestMapping("/sys/dic/toEdit")
    public String toEdit(Model model, Integer id){
        SysDicVO sysDic = sysDicService.convertEntityToVO(sysDicService.getById(id));
        model.addAttribute("sysDic", sysDic);
        return "core/sys/dic/dic_edit";
    }

    @RequestMapping("/sys/dic/edit")
    @ResponseBody
    public Object edit(SysDicVO vo){
        try{
            SysDic sysDic = sysDicService.convertVOToEntity(vo);
            return Result.success(null, "添加成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("修改失败！\n" + e.getMessage());
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/sys/dic/delete")
    @ResponseBody
    @Transactional
    public Object delete(Integer id) {
        try {
            sysDicService.deleteWithAllSubById(id);
            return Result.success(null, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("删除失败！\n" + e.getMessage());
        }
    }

}
