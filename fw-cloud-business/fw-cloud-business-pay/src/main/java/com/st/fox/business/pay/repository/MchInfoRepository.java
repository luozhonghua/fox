package com.st.fox.business.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.fox.business.pay.domain.PayMchInfo;

public interface MchInfoRepository extends JpaRepository<PayMchInfo, Long> {

	PayMchInfo findPayMchInfoByMchId(String mchId);

}
