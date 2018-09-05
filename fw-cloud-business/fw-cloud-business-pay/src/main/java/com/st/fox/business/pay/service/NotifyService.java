package com.st.fox.business.pay.service;

import com.st.fox.business.pay.beans.NotifyBean;
import com.st.fox.business.pay.domain.PayOrder;

public interface NotifyService {

	public void notifyPayOrder(PayOrder payOrder);

	public void notifyPayOrder(NotifyBean notifyBean, int count);

}
