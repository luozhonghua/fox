package com.st.fox.admin.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.st.fox.admin.service.model.SysAdminMenu;
import com.st.fox.admin.service.util.MyMapper;

public interface SysAdminMenuDao extends  MyMapper<SysAdminMenu>  {
	/**
	 * 根据ruleIds查询菜单信息
	 * @param ruleIds 权限id
	 * @param status 状态值
	 * @return List<SysAdminMenu>
	 */
	List<SysAdminMenu> selectInRuleIds(@Param("ruleIds") String ruleIds, @Param("status") int status);
}