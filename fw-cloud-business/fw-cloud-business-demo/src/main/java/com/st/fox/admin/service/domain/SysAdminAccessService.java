package com.st.fox.admin.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.fox.admin.service.base.BaseServiceImpl;
import com.st.fox.admin.service.dao.SysAdminAccessDao;
import com.st.fox.admin.service.model.SysAdminAccess;
import tk.mybatis.mapper.common.Mapper;

@Service
public class SysAdminAccessService extends BaseServiceImpl<SysAdminAccess>{
	
	@Autowired
	private SysAdminAccessDao sysAdminAccessDao;
	
	@Override
	public Mapper<SysAdminAccess> getMapper() {
		return sysAdminAccessDao;
	}

	public void saveOrUpdate(SysAdminAccess access){
       Integer i= sysAdminAccessDao.findAccess(access);
	    if(i==0)
        {
            sysAdminAccessDao.saveAccess(access);
        }else{
            sysAdminAccessDao.updateAccess(access);
        }
    }

    public int delete(Integer userId){
       return sysAdminAccessDao.deleteAccess(userId);
    }

}
