package com.st.fox.business.pay.repository;

import com.st.fox.business.pay.domain.RefundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundOrderRepository extends JpaRepository<RefundOrder, Long> {

}
