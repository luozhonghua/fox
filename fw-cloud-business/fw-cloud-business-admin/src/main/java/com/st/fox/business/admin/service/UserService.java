package com.st.fox.business.admin.service;

import com.st.fox.business.admin.beans.UserBean;
import com.st.fox.business.admin.beans.UserForm;
import com.st.fox.business.admin.domain.User;
import com.st.fox.commons.base.page.PageBean;
import com.st.fox.commons.base.page.PageParams;
import com.st.fox.system.api.model.AuthUser;

public interface UserService {

	public AuthUser findUserByUsername(String username);

	public User findUserByUsername(String username, boolean isLoadRole);

	public AuthUser findUserByMobile(String mobile);

	public void saveImageCode(String randomStr, String text);

	public UserBean findUserInfo(AuthUser user);

	public AuthUser findByUserId(String userId);

	public PageBean<User> findAll(PageParams pageParams, User user);

	public Boolean delByUserId(Integer userId);

	public boolean addUserAndRoleDept(UserForm userForm);

	public boolean updateUserAndRoleDept(UserForm userForm);

	public boolean updateUser(User user);

}
