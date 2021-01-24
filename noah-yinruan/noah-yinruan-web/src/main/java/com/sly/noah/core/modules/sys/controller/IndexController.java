package com.sly.noah.core.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.sly.noah.core.frontend.model.LayuiMiniMenuTree;
import com.sly.noah.core.frontend.model.layuimini.LayuiMiniConfig;
import com.sly.noah.core.frontend.model.Result;
import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Created by wj on 2020/12/10
 * @Description TODO
 */
@Controller
public class IndexController {

    @Resource
    private RbacResourceService rbacResourceService;


    @RequestMapping(value = "/login")
    public String login() {
        if (false) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request, String username, String password) {
        try {
            return Result.success();
        } catch (Exception e) {
            return Result.failed(e.getMessage());
        }
    }

    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping("/index/layuiMiniConfig/json")
    @ResponseBody
    public LayuiMiniConfig layuiMiniConfigByJson(){
        LayuiMiniConfig layuiMiniConfig = new LayuiMiniConfig();
        String str = "";
        try {
            File file = ResourceUtils.getFile("classpath:static/js/init1.json");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String data = null;
            while((data = br.readLine()) != null) {
                if(data != null){
                    str += data;
                }
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            layuiMiniConfig = JSONObject.toJavaObject(JSONObject.parseObject(str), LayuiMiniConfig.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return layuiMiniConfig;
    }

    @RequestMapping("/index/layui/menu")
    @ResponseBody
    public LayuiMiniConfig layuiMiniConfigByDb(){
        LayuiMiniMenuTree homeInfo = new LayuiMiniMenuTree();
        homeInfo.setTitle("首页");
        homeInfo.setHref("page/welcome-1.html?t=1");
        LayuiMiniMenuTree logoInfo = new LayuiMiniMenuTree();
        logoInfo.setTitle("LAYUI MINI");
        logoInfo.setImage("images/logo.png");
        logoInfo.setHref("");
        LayuiMiniConfig layuiMiniConfig = new LayuiMiniConfig();
        layuiMiniConfig.setHomeInfo(homeInfo);
        layuiMiniConfig.setLogoInfo(logoInfo);
        layuiMiniConfig.setMenuInfo(rbacResourceService.findAllLayTree());
        return layuiMiniConfig;
    }







}
