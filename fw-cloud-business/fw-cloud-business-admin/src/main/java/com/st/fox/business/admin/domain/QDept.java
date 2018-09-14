package com.st.fox.business.admin.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QDept is a Querydsl query type for Dept
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDept extends EntityPathBase<Dept> {

    private static final long serialVersionUID = -455292159L;

    public static final QDept dept = new QDept("dept");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> deptId = createNumber("deptId", Integer.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> pid = createNumber("pid", Integer.class);

    public final NumberPath<Integer> pos = createNumber("pos", Integer.class);

    public final NumberPath<Integer> statu = createNumber("statu", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QDept(String variable) {
        super(Dept.class, forVariable(variable));
    }

    public QDept(Path<? extends Dept> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDept(PathMetadata metadata) {
        super(Dept.class, metadata);
    }

}

