package com.st.fox.business.admin.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QDict is a Querydsl query type for Dict
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDict extends EntityPathBase<Dict> {

    private static final long serialVersionUID = -455288718L;

    public static final QDict dict = new QDict("dict");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath label = createString("label");

    public final NumberPath<Integer> statu = createNumber("statu", Integer.class);

    public final StringPath type = createString("type");

    public final StringPath value = createString("value");

    public QDict(String variable) {
        super(Dict.class, forVariable(variable));
    }

    public QDict(Path<? extends Dict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDict(PathMetadata metadata) {
        super(Dict.class, metadata);
    }

}

