package com.st.fox.admin.service.model;

import com.st.fox.admin.service.base.BaseEntity;


import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
/**
 * Created by luozhonghua on 2018/8/16.
 */
@Setter
@Getter
@Table(name = SysAdminLog.TABLE_NAME)
public class SysAdminLog extends BaseEntity {

    public static final String	TABLE_NAME			= "sys_log";



    /**
     * 日志类型
     */
   // @Column(name = "type")
    private Integer				type;

    /**
     * 日志标题
     */
   // @Column(name = "title")
    private String				title;

    /**
     * 服务ID
     */
    //@Column(name = "service_id")
    private String				serviceId;

    /**
     * 创建者
     */
   // @Column(name = "create_by")
    private String				createBy;

    /**
     * 操作IP地址
     */
   // @Column(name = "remote_addr")
    private String				remoteAddr;

    /**
     * 用户代理
     */
   // @Column(name = "user_agent")
    private String				userAgent;

    /**
     * 请求URI
     */
   // @Column(name = "request_uri")
    private String				requestUri;

    /**
     * 操作方式
     */
  //  @Column(name = "method")
    private String				method;

    /**
     * 操作提交的数据
     */
   // @Column(name = "params")
    private String				params;

    /**
     * 执行时间
     */
   // @Column(name = "time")
    private Long				time;

    /**
     * 删除标记
     */
   // @Column(name = "statu")
    private Integer				statu				= 0;

    /**
     * 异常信息
     */
   // @Column(name = "exception")
    private String				exception;

    /**
     * 创建时间
     */
    //@Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    //@Column(name = "update_time")
    private Date				updateTime;

    /**
     * id = 18 丢失精度适配
     */
    private transient String	idView;

}
