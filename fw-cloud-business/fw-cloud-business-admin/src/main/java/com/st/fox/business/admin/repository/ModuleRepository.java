package com.st.fox.business.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.fox.business.admin.domain.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
