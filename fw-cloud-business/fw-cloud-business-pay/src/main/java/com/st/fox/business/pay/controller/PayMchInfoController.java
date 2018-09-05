package com.st.fox.business.pay.controller;

import com.st.fox.business.pay.domain.PayMchInfo;
import com.st.fox.business.pay.service.MchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.fox.business.commons.web.BaseController;
import com.st.fox.commons.base.R;

/**
 * 支付渠道商户信息获取
 * 
 * @author luozhonghua
 */
@RestController
@RequestMapping(value = "/pay/mchinfo")
public class PayMchInfoController extends BaseController {

	@Autowired
	private MchInfoService mchInfoService;

	@GetMapping("/find/{mchId}")
	public R<PayMchInfo> findMchInfoByMchId(@PathVariable String mchId) {
		return new R<PayMchInfo>().data(mchInfoService.findMchInfoByMchId(mchId));
	}

}
