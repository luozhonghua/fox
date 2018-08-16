package com.st.fox.business.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.st.fox.business.admin.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer>,
		QueryDslPredicateExecutor<UserRole> {

}
