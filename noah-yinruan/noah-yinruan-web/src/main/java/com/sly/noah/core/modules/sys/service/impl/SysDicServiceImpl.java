package com.sly.noah.core.modules.sys.service.impl;

import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.jpa.repository.SysDicRepo;
import com.sly.noah.core.modules.sys.jpa.specification.SysDicSpec;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
import com.sly.noah.core.modules.sys.service.SysDicService;
import com.sly.noah.core.modules.sys.vo.SysDicVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
@Service
public class SysDicServiceImpl implements SysDicService {

    @Resource
    private SysDicRepo sysDicRepo;

    @Override
    public long count(SysDicQueryBean queryBean) {
        return sysDicRepo.count(SysDicSpec.buildSpecification(queryBean));
    }

    @Override
    public SysDic getById(Integer id) {
        return sysDicRepo.findById(id).get();
    }

    @Override
    public SysDic save(SysDic sysDic) {
        return sysDicRepo.save(sysDic);
    }

    @Override
    public List<SysDic> getAll(SysDicQueryBean queryBean) {
        return sysDicRepo.findAll(SysDicSpec.buildSpecification(queryBean));
    }

    @Override
    public SysDicVO convertEntityToVO(SysDic sysDic) {
        SysDicVO vo = new SysDicVO();
        BeanUtils.copyProperties(sysDic, vo);
        return vo;
    }

    @Override
    public List<SysDicVO> convertEntityToVO(List<SysDic> sysDics) {
        List<SysDicVO> vos = new ArrayList<>();
        for(SysDic sysDic : sysDics){
            vos.add(convertEntityToVO(sysDic));
        }
        return vos;
    }

    @Override
    public SysDic convertVOToEntity(SysDicVO sysDicVO) {
        SysDic sysDic = new SysDic();
        BeanUtils.copyProperties(sysDicVO, sysDic);
        return sysDic;
    }

    @Override
    public void delete(Integer id) {
        sysDicRepo.deleteById(id);
    }

    @Override
    public void deleteWithAllSubById(Integer id) {
        //删除自身
        this.delete(id);
        //递归删除子节点
        SysDicQueryBean queryBean = new SysDicQueryBean();
        queryBean.setPid(id);
        List<SysDic> sysDics = getAll(queryBean);
        if (CollectionUtils.isNotEmpty(sysDics)){
            for(SysDic sysDic : sysDics){
                deleteWithAllSubById(sysDic.getId());
            }
        }
    }
}
