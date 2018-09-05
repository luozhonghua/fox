package com.st.fox.business.pay.service.impl;

import com.st.fox.business.pay.domain.PayChannel;
import com.st.fox.business.pay.domain.QPayChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.fox.business.commons.web.jpa.JPAFactoryImpl;
import com.st.fox.business.pay.repository.PayChannelRepository;
import com.st.fox.business.pay.service.PayChannelService;
import com.st.fox.commons.utils.StringHelper;

@Component
public class PayChannelServiceImpl extends JPAFactoryImpl implements PayChannelService {

	@Autowired
	private PayChannelRepository	payChannelRepository;

	@Override
	public PayChannel findPayChannel(String channelId, String mchId) {
		if (StringHelper.isBlank(channelId) || StringHelper.isBlank(mchId)) return null;

		QPayChannel qPayChannel = QPayChannel.payChannel;
		return this.queryFactory.selectFrom(qPayChannel).where(
				qPayChannel.channelId.eq(channelId.trim())).where(
				qPayChannel.mchId.eq(mchId.trim())).fetchFirst();
	}
}
