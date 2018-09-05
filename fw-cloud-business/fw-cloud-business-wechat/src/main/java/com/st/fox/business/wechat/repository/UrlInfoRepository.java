package com.st.fox.business.wechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.fox.business.wechat.domain.UrlInfo;

public interface UrlInfoRepository extends JpaRepository<UrlInfo, Long> {

}
