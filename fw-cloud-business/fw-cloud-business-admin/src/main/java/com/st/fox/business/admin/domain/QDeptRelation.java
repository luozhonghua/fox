package com.st.fox.business.admin.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QDeptRelation is a Querydsl query type for DeptRelation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeptRelation extends EntityPathBase<DeptRelation> {

    private static final long serialVersionUID = 66361373L;

    public static final QDeptRelation deptRelation = new QDeptRelation("deptRelation");

    public final NumberPath<Integer> afterId = createNumber("afterId", Integer.class);

    public final NumberPath<Integer> preId = createNumber("preId", Integer.class);

    public QDeptRelation(String variable) {
        super(DeptRelation.class, forVariable(variable));
    }

    public QDeptRelation(Path<? extends DeptRelation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeptRelation(PathMetadata metadata) {
        super(DeptRelation.class, metadata);
    }

}

