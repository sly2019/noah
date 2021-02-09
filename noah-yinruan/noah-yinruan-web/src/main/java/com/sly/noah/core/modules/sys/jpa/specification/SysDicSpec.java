package com.sly.noah.core.modules.sys.jpa.specification;

import com.sly.noah.core.modules.sys.jpa.entity.SysDic;
import com.sly.noah.core.modules.sys.query_bean.SysDicQueryBean;
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

    }

    private static String buildLikeString(String likeStr) {
        return "%" + likeStr + "%";
    }

}
