package com.st.fox.business.admin.service;

import java.util.List;

import com.st.fox.business.admin.domain.DeptRelation;

public interface DeptRelationService {

	List<DeptRelation> findListByPreId(Integer preId);

	void saveOrUpdate(DeptRelation deptRelation);

}
