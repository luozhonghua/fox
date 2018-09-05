package com.st.fox.business.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.fox.business.pay.domain.PayOrder;

public interface PayOrderRepository extends JpaRepository<PayOrder, Long> {

	PayOrder findPayOrderByPayOrderId(String payOrderId);

}
