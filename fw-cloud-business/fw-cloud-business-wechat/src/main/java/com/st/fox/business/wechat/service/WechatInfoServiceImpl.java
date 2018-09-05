package com.st.fox.business.wechat.service;

import com.st.fox.business.wechat.domain.QWechatInfo;
import com.st.fox.business.wechat.domain.WechatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.st.fox.business.commons.web.jpa.JPAFactoryImpl;
import com.st.fox.business.wechat.repository.WechatInfoRepository;
import com.st.fox.commons.utils.StringHelper;

@CacheConfig(cacheNames = "wechat_info_")
@Component
public class WechatInfoServiceImpl extends JPAFactoryImpl implements WechatInfoService {

	@Autowired
	private WechatInfoRepository	wechatInfoRepository;

	@Override
	@Cacheable(key = "#wechatId")
	public WechatInfo findByWechatId(String wechatId) {
		if (StringHelper.isBlank(wechatId)) return null;

		QWechatInfo qWechatInfo = QWechatInfo.wechatInfo;
		return this.queryFactory.selectFrom(qWechatInfo).where(
				qWechatInfo.wechatId.eq(wechatId.trim())).where(qWechatInfo.statu.eq(1))
				.fetchFirst();
	}

}
