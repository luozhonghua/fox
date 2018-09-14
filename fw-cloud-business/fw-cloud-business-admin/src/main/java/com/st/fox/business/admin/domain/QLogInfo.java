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
 * QLogInfo is a Querydsl query type for LogInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLogInfo extends EntityPathBase<LogInfo> {

    private static final long serialVersionUID = -1315085354L;

    public static final QLogInfo logInfo = new QLogInfo("logInfo");

    public final StringPath createBy = createString("createBy");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath exception = createString("exception");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath method = createString("method");

    public final StringPath params = createString("params");

    public final StringPath remoteAddr = createString("remoteAddr");

    public final StringPath requestUri = createString("requestUri");

    public final StringPath serviceId = createString("serviceId");

    public final NumberPath<Integer> statu = createNumber("statu", Integer.class);

    public final NumberPath<Long> time = createNumber("time", Long.class);

    public final NumberPath<Integer> title = createNumber("title", Integer.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final StringPath userAgent = createString("userAgent");

    public QLogInfo(String variable) {
        super(LogInfo.class, forVariable(variable));
    }

    public QLogInfo(Path<? extends LogInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLogInfo(PathMetadata metadata) {
        super(LogInfo.class, metadata);
    }

}

