package com.st.fox.business.admin.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRoleMenuPermission is a Querydsl query type for RoleMenuPermission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleMenuPermission extends EntityPathBase<RoleMenuPermission> {

    private static final long serialVersionUID = 1672275552L;

    public static final QRoleMenuPermission roleMenuPermission = new QRoleMenuPermission("roleMenuPermission");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath permission = createString("permission");

    public final NumberPath<Integer> roleMenuId = createNumber("roleMenuId", Integer.class);

    public QRoleMenuPermission(String variable) {
        super(RoleMenuPermission.class, forVariable(variable));
    }

    public QRoleMenuPermission(Path<? extends RoleMenuPermission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleMenuPermission(PathMetadata metadata) {
        super(RoleMenuPermission.class, metadata);
    }

}

