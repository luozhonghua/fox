package com.st.fox.business.pay.repository;

import com.st.fox.business.pay.domain.PayChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayChannelRepository extends JpaRepository<PayChannel, Long> {

}
