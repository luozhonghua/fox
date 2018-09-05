package com.st.fox.business.pay.repository;

import com.st.fox.business.pay.domain.TransOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransOrderRepository extends JpaRepository<TransOrder, Long> {

}
