package com.st.fox.business.pay.service;

import com.st.fox.business.pay.domain.PayChannel;

public interface PayChannelService {

	PayChannel findPayChannel(String channelId, String mchId);

}
