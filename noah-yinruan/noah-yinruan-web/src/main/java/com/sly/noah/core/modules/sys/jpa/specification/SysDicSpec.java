package com.sly.noah.core.modules.sys.jpa.specification;

import com.sly.noah.core.modules.sys.enums.SysDicEnums;
import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/2/9
 * @Description: TODO
 */
public class SysDicSpec {

    public static Specification<SysDic> buildSpecification(SysDicQueryBean queryBean) {
        if (queryBean == null) {
            return null;
        }
        return (Specification<SysDic>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            {
                baseBuild(queryBean, root, builder, predicates);
            }

            query.where(predicates.toArray(new Predicate[] {}));
            return null;
        };
    }

    private static void baseBuild(SysDicQueryBean queryBean, Root<SysDic> root, CriteriaBuilder builder, List<Predicate> predicates) {

        //id
        {
            if(queryBean.getId() != null){
                predicates.add(builder.equal(root.get(SysDicEnums.PropertyJoinEnum.id.name()), queryBean.getId()));
            }
            if(queryBean.getIdIsNotIn() != null && queryBean.getIdIsNotIn().length > 0){
                predicates.add(root.get(SysDicEnums.PropertyJoinEnum.id.name()).in(queryBean.getIdIsNotIn()).not());
            }
        }
        //code
        {
            if(StringUtils.isNotBlank(queryBean.getCode())){
                predicates.add(builder.equal(root.get(SysDicEnums.PropertyEnum.code.name()), queryBean.getCode()));
            }
        }
        //pid
        {
            if(queryBean.getPid() != null){
                predicates.add(builder.equal(root.get(SysDicEnums.PropertyEnum.pid.name()), queryBean.getPid()));
            }
        }


    }

    private static String buildLikeString(String likeStr) {
        return "%" + likeStr + "%";
    }

}
