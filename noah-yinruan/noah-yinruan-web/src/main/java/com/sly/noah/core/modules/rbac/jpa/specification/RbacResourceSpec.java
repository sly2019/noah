package com.sly.noah.core.modules.rbac.jpa.specification;

import com.sly.noah.core.modules.rbac.enums.RbacResourceColumnNameEnums;
import com.sly.noah.core.modules.rbac.jpa.entity.RbacResource;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/2/8
 * @Description: TODO
 */
public class RbacResourceSpec {

    public static Specification<RbacResource> buildSpecification(RbacResourceQueryBean queryBean) {
        if (queryBean == null) {
            return null;
        }
        return (Specification<RbacResource>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            {
                baseBuild(queryBean, root, builder, predicates);
            }

            query.where(predicates.toArray(new Predicate[] {}));
            return null;
        };
    }

    private static void baseBuild(RbacResourceQueryBean queryBean, Root<RbacResource> root, CriteriaBuilder builder, List<Predicate> predicates) {

        //uri
        {
            if(StringUtils.isNotBlank(queryBean.getUri())){
                predicates.add(builder.equal(root.get(RbacResourceColumnNameEnums.PropertyEnum.uri.name()), queryBean.getUri()));
            }
        }
    }

    private static String buildLikeString(String likeStr) {
        return "%" + likeStr + "%";
    }

}
