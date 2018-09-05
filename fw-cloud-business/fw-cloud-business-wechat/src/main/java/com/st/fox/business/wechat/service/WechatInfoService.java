package com.st.fox.business.wechat.service;

import com.st.fox.business.wechat.domain.WechatInfo;

public interface WechatInfoService {

	WechatInfo findByWechatId(String wechatId);

}
