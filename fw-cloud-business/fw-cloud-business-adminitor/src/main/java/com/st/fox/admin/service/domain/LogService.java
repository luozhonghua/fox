package com.st.fox.admin.service.domain;

import com.st.fox.admin.service.base.BaseServiceImpl;
import com.st.fox.admin.service.dao.SysAdminLogDao;
import com.st.fox.admin.service.model.SysAdminLog;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by luozhonghua on 2018/8/16.
 */
public class LogService extends BaseServiceImpl<SysAdminLog> {


    @Autowired
    private SysAdminLogDao sysAdminLogDao;


    @Override
    public Mapper<SysAdminLog> getMapper() {
        return sysAdminLogDao;
    }

    public void saveOrUpdate(SysAdminLog logInfo){

    };
}
