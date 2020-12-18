package com.sly.noah.core.modules.rbac.dao;

import com.sly.noah.core.modules.rbac.entity.RbacResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Created by wj on 2020/12/14
 * @Description TODO
 */
@Mapper
@Repository
public interface  RbacResourceDao {

    int count();

    RbacResource getById(Integer id);

}
