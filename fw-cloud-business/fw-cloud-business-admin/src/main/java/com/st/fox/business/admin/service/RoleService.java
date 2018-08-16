package com.st.fox.business.admin.service;

import java.util.List;

import com.st.fox.business.admin.beans.RoleDeptBean;
import com.st.fox.business.admin.domain.Role;
import com.st.fox.commons.base.page.PageBean;
import com.st.fox.commons.base.page.PageParams;

public interface RoleService {

	List<Role> findRoleListByDeptId(Integer deptId);

	List<Role> getRoleList();

	PageBean<RoleDeptBean> findAll(PageParams pageParams, Role role);

	Role saveOrUpdate(Role role);

	Role saveRoleAndDept(Role role);

	boolean delById(Integer roleId);

	Role findRoleByCode(String roleCode);

}
