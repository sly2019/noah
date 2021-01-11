package com.sly.noah.core.modules.rbac.service;

import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVO;

import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
public interface RbacResourceService {

    int count();

    RbacResource getById(Integer id);

    int save(RbacResource rbacResource);

    List<RbacResource> getAll();

    List<RbacResource> getAll(RbacResourceQueryBean queryBean);

    RbacResourceVO convertEntityToVO(RbacResource rbacResource);

    List<RbacResourceVO> convertEntityToVO(List<RbacResource> rbacResources);

    RbacResource convertVOToEntity(RbacResourceVO rbacResourceVO);

    void delete(Integer id);

    /**
     * 删除本身及其所有子孙
     *
     * @param id
     */
    void deleteWithAllSubById(Integer id);


}
