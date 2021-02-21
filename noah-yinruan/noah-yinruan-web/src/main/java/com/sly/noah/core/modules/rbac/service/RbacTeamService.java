package com.sly.noah.core.modules.rbac.service;

import com.sly.noah.core.modules.rbac.jpa.entity.RbacTeam;
import com.sly.noah.core.modules.rbac.query_bean.RbacTeamQueryBean;
import com.sly.noah.core.modules.rbac.vo.RbacTeamVO;

import java.util.List;

/**
 * @Created by wj on 2021/2/16
 * @Description: TODO
 */
public interface RbacTeamService {

    long count(RbacTeamQueryBean queryBean);

    RbacTeam getById(Integer id);

    RbacTeam save(RbacTeam rbacTeam);

    List<RbacTeam> getAll(RbacTeamQueryBean queryBean);

    RbacTeamVO convertEntityToVO(RbacTeam rbacTeam);

    List<RbacTeamVO> convertEntityToVO(List<RbacTeam> rbacTeams);

    RbacTeam convertVOToEntity(RbacTeamVO rbacTeamVO);

    void delete(Integer id);

    /**
     * 递归删除
     * @param id
     */
    void deleteWithAllSubById(Integer id);

}
