package com.st.fox.business.admin.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QModule is a Querydsl query type for Module
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QModule extends EntityPathBase<Module> {

    private static final long serialVersionUID = 817443880L;

    public static final QModule module = new QModule("module");

    public final StringPath code = createString("code");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QModule(String variable) {
        super(Module.class, forVariable(variable));
    }

    public QModule(Path<? extends Module> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModule(PathMetadata metadata) {
        super(Module.class, metadata);
    }

}

