package com.st.fox.business.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.st.fox.business.admin.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>,
		QueryDslPredicateExecutor<Menu> {

}
