package com.st.fox.business.pay.service;

import java.util.Map;

import com.st.fox.business.pay.domain.PayOrder;
import com.st.fox.commons.base.R;

public interface WxUnifiedOrderService {

	public R<Map<String, Object>> doWxUnifiedOrderRequest(String tradeTypeApp, PayOrder payOrder,
			Map<String, String> params);

}
