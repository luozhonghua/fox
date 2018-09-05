package com.st.fox.business.pay.repository;

import com.st.fox.business.pay.domain.IapReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IapReceiptRepository extends JpaRepository<IapReceipt, Long> {

}
