package com.sly.noah.core.modules.rbac.dao;

import com.sly.noah.core.modules.rbac.entity.RbacRole;
import com.sly.noah.core.modules.rbac.query_bean.RbacRoleQueryBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wj
 * @Date: 2021/1/24 15:18:49
 * @Description: TODO
 */
@Mapper
@Repository
public interface RbacRoleDao {

    int count();

    RbacRole getById(Integer id);

    List<RbacRole> getAll();

    List<RbacRole> getByQueryBean(RbacRoleQueryBean queryBean);

    int add(RbacRole rbacRole);

    int delete(Integer id);

}
