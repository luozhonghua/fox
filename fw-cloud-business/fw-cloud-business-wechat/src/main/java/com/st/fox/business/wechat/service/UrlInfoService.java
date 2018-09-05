package com.st.fox.business.wechat.service;

import com.st.fox.business.wechat.beans.UrlInfoBean;
import com.st.fox.business.wechat.domain.UrlInfo;

public interface UrlInfoService {

	UrlInfo findByUuid(String uuid);

	UrlInfo saveOrUpdate(UrlInfo urlInfo);

	UrlInfoBean findFromCacheByUuid(String uuid);

	void cacheUrlInfo(UrlInfoBean urlInfoBean);

	long clearAllExpire();
}
