package com.st.fox.business.pay.service;

import com.st.fox.business.pay.domain.PayMchInfo;

public interface MchInfoService {

	PayMchInfo findMchInfoByMchId(String mchId);
}
