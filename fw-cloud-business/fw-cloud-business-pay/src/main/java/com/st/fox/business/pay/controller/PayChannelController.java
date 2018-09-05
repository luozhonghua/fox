package com.st.fox.business.pay.controller;

import com.st.fox.business.pay.domain.PayChannel;
import com.st.fox.business.pay.service.PayChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.fox.commons.base.R;

/**
 * 支付渠道信息获取
 * 
 * @author luozhonghua
 */
@RestController
@RequestMapping(value = "/pay/channel")
public class PayChannelController {

	@Autowired
	private PayChannelService payChannelService;

	@RequestMapping(value = "/find/{channelId}/{mchId}")
	public R<PayChannel> selectPayChannel(@PathVariable String channelId, @PathVariable String mchId) {

		PayChannel payChannel = payChannelService.findPayChannel(channelId, mchId);

		return new R<PayChannel>().data(payChannel);
	}
}
