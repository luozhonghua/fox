package com.st.fox.business.wechat.repository;

import com.st.fox.business.wechat.domain.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthInfoRepository extends JpaRepository<AuthInfo, Long> {

}
