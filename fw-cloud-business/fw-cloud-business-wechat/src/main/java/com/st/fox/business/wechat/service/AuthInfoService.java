package com.st.fox.business.wechat.service;

import com.st.fox.business.wechat.domain.AuthInfo;

public interface AuthInfoService {

	AuthInfo saveOrUpdate(AuthInfo authInfo);

	AuthInfo findByOpenIdAndWechatId(String openId, String wechatId);

}
