package com.sly.noah.core.modules.rbac.service.impl;

import com.sly.noah.core.modules.rbac.dao.RbacResourceDao;
import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVO;
import org.apache.commons.collections.CollectionUtils;
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
    public int save(RbacResource rbacResource) {
        return rbacResourceDao.add(rbacResource);
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
    public List<RbacResource> getAll(RbacResourceQueryBean queryBean) {
        return rbacResourceDao.getAll(queryBean);
    }

    @Override
    public RbacResourceVO convertEntityToVO(RbacResource rbacResource) {
        if(rbacResource == null){
            return null;
        }
        RbacResourceVO vo = new RbacResourceVO();
        BeanUtils.copyProperties(rbacResource, vo);
        return vo;
    }

    @Override
    public List<RbacResourceVO> convertEntityToVO(List<RbacResource> rbacResources) {
        List<RbacResourceVO> vos = new LinkedList<>();
        for(RbacResource rbacResource : rbacResources){
            vos.add(convertEntityToVO(rbacResource));
        }
        return vos;
    }

    @Override
    public RbacResource convertVOToEntity(RbacResourceVO rbacResourceVO) {
        RbacResource rbacResource = new RbacResource();
        BeanUtils.copyProperties(rbacResourceVO, rbacResource);
        return rbacResource;
    }

    @Override
    public void delete(Integer id) {
        rbacResourceDao.delete(id);
    }

    @Override
    public void deleteWithAllSubById(Integer id) {
        //删除自身
        this.delete(id);
        //递归删除子节点
        RbacResourceQueryBean queryBean = new RbacResourceQueryBean();
        queryBean.setPid(id);
        List<RbacResource> rbacResourcesTemp = getAll(queryBean);
        if (CollectionUtils.isNotEmpty(rbacResourcesTemp)){
            for(RbacResource rbacResource : rbacResourcesTemp){
                deleteWithAllSubById(rbacResource.getId());
            }
        }
    }

}
