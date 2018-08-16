package com.st.fox.business.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.fox.business.admin.domain.LogInfo;
import com.st.fox.business.admin.service.LogInfoService;
import com.st.fox.business.commons.permission.Functional;
import com.st.fox.business.commons.permission.Module;
import com.st.fox.business.commons.web.BaseController;
import com.st.fox.business.commons.web.aop.PrePermissions;
import com.st.fox.commons.base.R;
import com.st.fox.commons.base.page.PageBean;
import com.st.fox.commons.base.page.PageParams;

@RestController
@RequestMapping("/logs")
@PrePermissions(value = Module.LOG)
public class LogController extends BaseController {

	@Autowired
	private LogInfoService	logInfoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PrePermissions(value = Functional.VIEW)
	public R<PageBean<LogInfo>> list(HttpServletRequest request, LogInfo logInfo,
			PageParams pageParams) {
		PageBean<LogInfo> pageData = this.logInfoService.findAll(pageParams, logInfo);
		return new R<PageBean<LogInfo>>().data(pageData);
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
	@PrePermissions(value = Functional.DEL)
	public R<Boolean> del(HttpServletRequest request, @PathVariable Long id) {
		if (null == id || id <= 0)
			return new R<Boolean>().data(false).failure("日志id为空");

		boolean isDel = this.logInfoService.delById(id);
		return new R<Boolean>().data(isDel);
	}
}
