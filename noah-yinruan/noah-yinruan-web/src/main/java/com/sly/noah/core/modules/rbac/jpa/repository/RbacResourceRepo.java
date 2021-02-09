package com.sly.noah.core.modules.rbac.jpa.repository;

import com.sly.noah.core.modules.rbac.jpa.entity.RbacResource;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Created by wj on 2020/12/13
 * @Description TODO
 */
public interface RbacResourceRepo extends CrudRepository<RbacResource, Integer>, JpaSpecificationExecutor<RbacResource> {
}
