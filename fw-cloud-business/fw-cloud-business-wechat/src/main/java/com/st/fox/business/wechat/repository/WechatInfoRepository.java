package com.st.fox.business.wechat.repository;

import com.st.fox.business.wechat.domain.WechatInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WechatInfoRepository extends JpaRepository<WechatInfo, Long> {

}
