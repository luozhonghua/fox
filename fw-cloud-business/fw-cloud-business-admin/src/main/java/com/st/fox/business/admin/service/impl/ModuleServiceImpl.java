package com.st.fox.business.admin.service.impl;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.st.fox.business.admin.cache.AdminCacheKey;
import com.st.fox.business.admin.domain.Module;
import com.st.fox.business.admin.domain.QModule;
import com.st.fox.business.admin.service.ModuleService;
import com.st.fox.business.commons.web.jpa.JPAFactoryImpl;

@Component
@CacheConfig(cacheNames = AdminCacheKey.MODULE_INFO)
public class ModuleServiceImpl extends JPAFactoryImpl implements ModuleService {

	@Override
	@Cacheable(key = "'module_list'")
	public List<Module> getAllList() {
		QModule qModule = QModule.module;

		return this.queryFactory.selectFrom(qModule).fetch();
	}

}
