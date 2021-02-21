package com.sly.noah.core.modules.sys.service;

import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
import com.sly.noah.core.modules.sys.vo.SysDicVO;

import java.util.List;
import java.util.Map;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
public interface SysDicService {

    /**
     * 加载字典
     */
    void reloadDic();

    /**
     * 仅更新
     * @param pid
     */
    void reloadDic(Integer id, Integer pid);

    /**
     * 根据字典编码获取字典
     * @param code
     * @return
     */
    List<SysDic> getDic(String code);

    /**
     * 获取字典map <code, name>
     * @param code
     * @return
     */
    Map<String, String> getDicMap(String code);

    long count(SysDicQueryBean queryBean);

    SysDic getById(Integer id);

    SysDic save(SysDic sysDic);

    List<SysDic> getAll(SysDicQueryBean queryBean);

    SysDicVO convertEntityToVO(SysDic sysDic);

    List<SysDicVO> convertEntityToVO(List<SysDic> sysDics);

    SysDic convertVOToEntity(SysDicVO sysDicVO);

    boolean isCodeRepeat(Integer id, Integer pid, String code);

    void delete(Integer id);

    void deleteWithAllSubById(Integer id);
}
