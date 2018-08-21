package com.st.fox.admin.service.dao;

import com.st.fox.admin.service.model.SysAdminAccess;
import com.st.fox.admin.service.util.MyMapper;

public interface SysAdminAccessDao extends MyMapper<SysAdminAccess> {


    Integer findAccess(SysAdminAccess sysAdminAccess);

    void saveAccess(SysAdminAccess sysAdminAccess);

    void updateAccess(SysAdminAccess sysAdminAccess);
}