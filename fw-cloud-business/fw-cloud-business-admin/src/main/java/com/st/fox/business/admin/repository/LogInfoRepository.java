package com.st.fox.business.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.st.fox.business.admin.domain.LogInfo;

public interface LogInfoRepository extends JpaRepository<LogInfo, Long>,
		QueryDslPredicateExecutor<LogInfo> {

}
