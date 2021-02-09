package com.sly.noah.core.modules.sys.jpa.repository;

import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
public interface SysDicRepo extends CrudRepository<SysDic, Integer>, JpaSpecificationExecutor<SysDic> {
}
