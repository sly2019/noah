package com.sly.noah.core.modules.rbac.service.impl;

import com.sly.noah.core.frontend.helper.TreeVOHelper;
import com.sly.noah.core.frontend.model.LayuiMiniMenuTree;
import com.sly.noah.core.modules.rbac.jpa.entity.RbacResource;
import com.sly.noah.core.modules.rbac.jpa.repository.RbacResourceRepo;
import com.sly.noah.core.modules.rbac.jpa.specification.RbacResourceSpec;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import com.sly.noah.core.modules.rbac.service.RbacResourceService;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
@Service
public class RbacResourceServiceImpl implements RbacResourceService {

    @Resource
    private RbacResourceRepo rbacResourceRepo;

    @Override
    public long count(RbacResourceQueryBean queryBean) {
        return rbacResourceRepo.count(RbacResourceSpec.buildSpecification(queryBean));
    }

    @Override
    public RbacResource save(RbacResource rbacResource) {
        return rbacResourceRepo.save(rbacResource);
    }

    @Override
    public RbacResource getById(Integer id) {
        return rbacResourceRepo.findById(id).get();
    }

    @Override
    public List<RbacResource> getAll(RbacResourceQueryBean queryBean) {
        return rbacResourceRepo.findAll(RbacResourceSpec.buildSpecification(queryBean));
    }

    @Override
    public List<RbacResource> getAll(RbacResourceQueryBean queryBean, Sort sort) {
        return rbacResourceRepo.findAll(RbacResourceSpec.buildSpecification(queryBean), sort);
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
        rbacResourceRepo.deleteById(id);
    }

    @Override
    public void deleteWithAllSubById(Integer id) {
        //????????????
        this.delete(id);
        //?????????????????????
        RbacResourceQueryBean queryBean = new RbacResourceQueryBean();
        queryBean.setPid(id);
        List<RbacResource> rbacResourcesTemp = getAll(queryBean);
        if (CollectionUtils.isNotEmpty(rbacResourcesTemp)){
            for(RbacResource rbacResource : rbacResourcesTemp){
                deleteWithAllSubById(rbacResource.getId());
            }
        }
    }

    @Override
    public List<LayuiMiniMenuTree> findAllLayTree() {
        RbacResourceQueryBean queryBean = new RbacResourceQueryBean();
        queryBean.setType("3");
        List<RbacResourceVO> rbacResourceVOS = convertEntityToVO(getAll(queryBean));
        List<LayuiMiniMenuTree> trees = new ArrayList<>();
        for (RbacResourceVO rbacResourceVO : rbacResourceVOS) {
            LayuiMiniMenuTree tree = new LayuiMiniMenuTree();
            tree.setId(String.valueOf(rbacResourceVO.getId()));
            tree.setPid(String.valueOf(rbacResourceVO.getPid()));
            tree.setSpread(false);
            tree.setName(rbacResourceVO.getName());
            tree.setTitle(rbacResourceVO.getName());
            tree.setHref(rbacResourceVO.getUri());
            tree.setTarget("_self");
            tree.setIcon("fa fa-address-book");
            trees.add(tree);
        }
        List<LayuiMiniMenuTree> treeData = TreeVOHelper.getInstance().convertTreeModeFromPidToChildren(trees);
        return treeData;
    }




}
