package com.sly.noah.core.modules.rbac.service.impl;

import com.sly.noah.core.modules.rbac.dao.RbacResourceDao;
import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
@Service
public class RbacResourceServiceImpl implements RbacResourceService {

    @Autowired
    private RbacResourceDao rbacResourceDao;

    @Override
    public int count() {
        return rbacResourceDao.count();
    }

    @Override
    public RbacResource getById(Integer id) {
        return rbacResourceDao.getById(id);
    }

    @Override
    public List<RbacResource> getAll() {
        return rbacResourceDao.getAll();
    }

    @Override
    public RbacResourceVo convertEntityToVo(RbacResource rbacResource) {
        if(rbacResource == null){
            return null;
        }
        RbacResourceVo vo = new RbacResourceVo();
        BeanUtils.copyProperties(rbacResource, vo);
        return vo;
    }

    @Override
    public List<RbacResourceVo> convertEntityToVo(List<RbacResource> rbacResources) {
        List<RbacResourceVo> vos = new LinkedList<>();
        for(RbacResource rbacResource : rbacResources){
            vos.add(convertEntityToVo(rbacResource));
        }
        return vos;
    }
}
