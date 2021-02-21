package com.sly.noah.core.modules.rbac.service.impl;

import com.sly.noah.core.modules.rbac.jpa.entity.RbacTeam;
import com.sly.noah.core.modules.rbac.jpa.repository.RbacTeamRepo;
import com.sly.noah.core.modules.rbac.jpa.specification.RbacTeamSpec;
import com.sly.noah.core.modules.rbac.query_bean.RbacTeamQueryBean;
import com.sly.noah.core.modules.rbac.service.RbacTeamService;
import com.sly.noah.core.modules.rbac.vo.RbacTeamVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Created by wj on 2021/2/16
 * @Description: TODO
 */
@Service
public class RbacTeamServiceImpl implements RbacTeamService {

    @Resource
    private RbacTeamRepo rbacTeamRepo;

    @Override
    public long count(RbacTeamQueryBean queryBean) {
        return rbacTeamRepo.count(RbacTeamSpec.buildSpecification(queryBean));
    }

    @Override
    public RbacTeam getById(Integer id) {
        return rbacTeamRepo.findById(id).get();
    }

    @Override
    public RbacTeam save(RbacTeam rbacTeam) {
        return rbacTeamRepo.save(rbacTeam);
    }

    @Override
    public List<RbacTeam> getAll(RbacTeamQueryBean queryBean) {
        return rbacTeamRepo.findAll(RbacTeamSpec.buildSpecification(queryBean));
    }

    @Override
    public RbacTeamVO convertEntityToVO(RbacTeam rbacTeam) {
        RbacTeamVO vo = new RbacTeamVO();
        BeanUtils.copyProperties(rbacTeam, vo);
        return vo;
    }

    @Override
    public List<RbacTeamVO> convertEntityToVO(List<RbacTeam> rbacTeams) {
        return null;
    }

    @Override
    public RbacTeam convertVOToEntity(RbacTeamVO rbacTeamVO) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        rbacTeamRepo.deleteById(id);
    }

    @Override
    public void deleteWithAllSubById(Integer id) {
        //删除自身
        this.delete(id);
        //递归删除子节点
        RbacTeamQueryBean queryBean = new RbacTeamQueryBean();
        queryBean.setPid(id);
        List<RbacTeam> rbacTeams = getAll(queryBean);
        if (CollectionUtils.isNotEmpty(rbacTeams)){
            for(RbacTeam rbacTeam : rbacTeams){
                deleteWithAllSubById(rbacTeam.getId());
            }
        }
    }
}
