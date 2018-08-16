package com.st.fox.business.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.st.fox.business.admin.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>,
		QueryDslPredicateExecutor<User> {

	User findUserByUsername(String username);

	User findUserByMobile(String mobile);

	User findUserByOpenId(String openId);

	User findUserByUserId(Integer userId);

}
