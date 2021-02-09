package com.sly.noah.core.modules.sys.service;

import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
import com.sly.noah.core.modules.sys.vo.SysDicVO;

import java.util.List;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
public interface SysDicService {

    long count(SysDicQueryBean queryBean);

    SysDic getById(Integer id);

    SysDic save(SysDic sysDic);

    List<SysDic> getAll(SysDicQueryBean queryBean);

    SysDicVO convertEntityToVO(SysDic sysDic);

    List<SysDicVO> convertEntityToVO(List<SysDic> sysDics);

    SysDic convertVOToEntity(SysDicVO sysDicVO);

    void delete(Integer id);
}
