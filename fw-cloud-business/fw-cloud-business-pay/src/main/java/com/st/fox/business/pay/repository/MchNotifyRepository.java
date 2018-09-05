package com.st.fox.business.pay.repository;

import com.st.fox.business.pay.domain.PayMchNotify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MchNotifyRepository extends JpaRepository<PayMchNotify, Long> {

}
