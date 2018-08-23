package com.st.fox.admin.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.st.fox.admin.service.model.SysAdminRule;
import com.st.fox.admin.service.util.MyMapper;

public interface SysAdminRuleDao extends  MyMapper<SysAdminRule>  {

	List<SysAdminRule> selectInIds(@Param("ruleIds") String[] ruleIds,@Param("status") Integer status);

	List<SysAdminRule> selectByStatus(@Param("status") Integer status);
}