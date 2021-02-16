package com.sly.noah.core.modules.rbac.jpa.repository;

import com.sly.noah.core.modules.rbac.jpa.entity.RbacTeam;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Created by wj on 2021/2/16
 * @Description: TODO
 */
public interface RbacTeamRepo extends CrudRepository<RbacTeam, Integer>, JpaSpecificationExecutor<RbacTeam> {
}
