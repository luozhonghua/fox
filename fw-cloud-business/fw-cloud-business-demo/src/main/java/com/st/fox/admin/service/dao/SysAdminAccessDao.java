package com.st.fox.admin.service.dao;

import com.st.fox.admin.service.model.SysAdminAccess;
import com.st.fox.admin.service.util.MyMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

public interface SysAdminAccessDao extends MyMapper<SysAdminAccess> {


    Integer findAccess(SysAdminAccess sysAdminAccess);

    void saveAccess(SysAdminAccess sysAdminAccess);

    void updateAccess(SysAdminAccess sysAdminAccess);

    int deleteAccess(@Param("userId")  Integer userId);
}