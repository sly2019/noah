package com.sly.noah.core.modules.rbac.jpa.specification;

import com.sly.noah.core.modules.rbac.jpa.entity.RbacResource;
import com.sly.noah.core.modules.rbac.jpa.entity.RbacTeam;
import com.sly.noah.core.modules.rbac.query_bean.RbacResourceQueryBean;
import com.sly.noah.core.modules.rbac.query_bean.RbacTeamQueryBean;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/2/16
 * @Description: TODO
 */
public class RbacTeamSpec {

    public static Specification<RbacTeam> buildSpecification(RbacTeamQueryBean queryBean) {
        if (queryBean == null) {
            return null;
        }
        return (Specification<RbacTeam>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            {
                baseBuild(queryBean, root, builder, predicates);
            }

            query.where(predicates.toArray(new Predicate[] {}));
            return null;
        };
    }

    private static void baseBuild(RbacTeamQueryBean queryBean, Root<RbacTeam> root, CriteriaBuilder builder, List<Predicate> predicates) {

    }

    private static String buildLikeString(String likeStr) {
        return "%" + likeStr + "%";
    }

}
