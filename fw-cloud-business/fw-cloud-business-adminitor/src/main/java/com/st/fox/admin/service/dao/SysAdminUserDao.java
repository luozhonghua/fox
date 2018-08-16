package com.st.fox.admin.service.dao;

import com.st.fox.admin.service.model.SysAdminUser;
import com.st.fox.admin.service.util.MyMapper;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface SysAdminUserDao extends  MyMapper<SysAdminUser>  {
    List<SysAdminUser> selectAll();
}