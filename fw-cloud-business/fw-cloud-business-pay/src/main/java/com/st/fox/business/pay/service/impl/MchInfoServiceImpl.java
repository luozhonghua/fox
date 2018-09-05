package com.st.fox.business.pay.service.impl;

import com.st.fox.business.pay.domain.PayMchInfo;
import com.st.fox.business.pay.repository.MchInfoRepository;
import com.st.fox.business.pay.service.MchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.fox.commons.utils.StringHelper;

@Component
public class MchInfoServiceImpl implements MchInfoService {

	@Autowired
	private MchInfoRepository mchInfoRepository;

	@Override
	public PayMchInfo findMchInfoByMchId(String mchId) {
		if (StringHelper.isBlank(mchId)) return null;

		return mchInfoRepository.findPayMchInfoByMchId(mchId.trim());
	}

}
