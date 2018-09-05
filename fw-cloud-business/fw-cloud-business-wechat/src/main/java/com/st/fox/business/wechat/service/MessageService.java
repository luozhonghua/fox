package com.st.fox.business.wechat.service;

import me.chanjar.weixin.common.error.WxErrorException;

import com.st.fox.commons.pay.beans.MsgBean;
import com.st.fox.commons.pay.enums.WxTemplateEnum;

public interface MessageService {

	/**
	 * 发送微信模板消息通知
	 * 
	 * @param wxTemplateEnum
	 */
	boolean sendWeixinTemplateMessage(WxTemplateEnum wxTemplateEnum, MsgBean msgBean)
			throws WxErrorException;

}
