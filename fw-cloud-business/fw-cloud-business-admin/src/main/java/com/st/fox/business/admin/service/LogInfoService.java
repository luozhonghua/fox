package com.st.fox.business.admin.service;

import com.st.fox.business.admin.domain.LogInfo;
import com.st.fox.commons.base.page.PageBean;
import com.st.fox.commons.base.page.PageParams;

public interface LogInfoService {

	public void saveOrUpdate(LogInfo logInfo);

	/**
	 * 日志列表数据
	 */
	PageBean<LogInfo> findAll(PageParams pageParams, LogInfo logInfo);

	/**
	 * 日志删除
	 */
	boolean delById(Long id);
}
