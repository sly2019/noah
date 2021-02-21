package com.sly.noah.core.modules.sys.service.impl;

import com.sly.noah.core.frontend.model.Result;
import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.jpa.repository.SysDicRepo;
import com.sly.noah.core.modules.sys.jpa.specification.SysDicSpec;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
import com.sly.noah.core.modules.sys.service.SysDicService;
import com.sly.noah.core.modules.sys.vo.SysDicVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
@Service
public class SysDicServiceImpl implements SysDicService {

    @Resource
    private SysDicRepo sysDicRepo;

    /**
     * Map<String, List<SysDic>>： <父节点字典编码, 子节点列表>
     * 仅加载一级字典
     */
    private Map<String, List<SysDic>> codeMap = new HashMap<>();

    private static Logger _log = LoggerFactory.getLogger(SysDicServiceImpl.class);

    /**
     * 加载字典，每天凌晨3点更新一次，仅加载一级字典
     */
    @Scheduled(cron = "0 0 3 * * ?")
    @Override
    public synchronized void reloadDic(){
        _log.info("开始加载全部字典");
        Map<String, List<SysDic>> codeMapTemp = new HashMap<>();
        List<SysDic> sysDics = getAll(null);
        Map<Integer, SysDic> sysDicMap = new HashMap<>();
        for(SysDic sysDic : sysDics){
            sysDicMap.put(sysDic.getId(), sysDic);
        }
        for(SysDic sysDic : sysDics){
            if(sysDic.getPid() == null){
                codeMapTemp.put(sysDic.getCode(), new ArrayList<>());
            }
        }
        for(SysDic sysDic : sysDics){
            if(sysDic.getPid() == null){
                continue;
            }
            SysDic sysDicParent = sysDicMap.get(sysDic.getPid());
            if(sysDicParent == null){
                continue;
            }
            if(codeMapTemp.containsKey(sysDicParent.getCode())){
                codeMapTemp.get(sysDicParent.getCode()).add(sysDic);
            }
        }
        this.codeMap = codeMapTemp;
        _log.info("加载全部字典ok");
    }


    @Override
    public List<SysDic> getDic(String code){
        return codeMap.get(code);
    }

    @Override
    public Map<String, String> getDicMap(String code) {
        Map<String, String> map = new HashMap<>();
        List<SysDic> sysDics = codeMap.get(code);
        for(SysDic sysDic : sysDics){
            map.put(sysDic.getCode(), sysDic.getName());
        }
        return map;
    }

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
    public boolean isCodeRepeat(Integer id, Integer pid, String code) {
        SysDicQueryBean queryBean = new SysDicQueryBean();
        queryBean.setCode(code);
        queryBean.setPid(pid);
        if(id != null){
            queryBean.setIdIsNotIn(new Integer[]{id});
        }
        long count = count(queryBean);
        if(count > 0){
            return true;
        }
        return false;
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
