package com.sly.noah.core.modules.rbac.service;

import com.sly.noah.core.frontend.model.LayuiMiniMenuTree;
import com.sly.noah.core.modules.rbac.jpa.entity.RbacResource;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import com.sly.noah.core.modules.rbac.vo.RbacResourceVO;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
public interface RbacResourceService {

    long count(RbacResourceQueryBean queryBean);

    RbacResource getById(Integer id);

    RbacResource save(RbacResource rbacResource);

    List<RbacResource> getAll(RbacResourceQueryBean queryBean);

    List<RbacResource> getAll(RbacResourceQueryBean queryBean, Sort sort);

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


    /**
     * 取出所有的资源，并封装成树型结构
     *
     * @return
     */
    List<LayuiMiniMenuTree> findAllLayTree();


}
