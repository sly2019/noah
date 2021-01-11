package com.sly.noah.core.modules.rbac.dao;

import com.sly.noah.core.modules.rbac.entity.RbacResource;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
@Mapper
@Repository
public interface  RbacResourceDao {

    int count();

    RbacResource getById(Integer id);

    List<RbacResource> getAll();

    List<RbacResource> getAll(RbacResourceQueryBean queryBean);

    int add(RbacResource rbacResource);

    int delete(Integer id);


}
