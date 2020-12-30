package com.sly.noah.core.modules.rbac.service;

import com.sly.noah.core.modules.rbac.entity.RbacResource;

import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
public interface RbacResourceService {

    /**
     * 统计数量
     * @return
     */
    int count();

    /**
     * 通过id查找
     * @param id
     * @return
     */
    RbacResource getById(Integer id);

    /**
     * 获取所有资源
     * @return
     */
    List<RbacResource> getAll();


}
