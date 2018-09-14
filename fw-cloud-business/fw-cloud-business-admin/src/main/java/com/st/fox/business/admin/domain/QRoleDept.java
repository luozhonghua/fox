package com.st.fox.business.admin.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRoleDept is a Querydsl query type for RoleDept
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleDept extends EntityPathBase<RoleDept> {

    private static final long serialVersionUID = -78260585L;

    public static final QRoleDept roleDept = new QRoleDept("roleDept");

    public final NumberPath<Integer> deptId = createNumber("deptId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QRoleDept(String variable) {
        super(RoleDept.class, forVariable(variable));
    }

    public QRoleDept(Path<? extends RoleDept> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleDept(PathMetadata metadata) {
        super(RoleDept.class, metadata);
    }

}

