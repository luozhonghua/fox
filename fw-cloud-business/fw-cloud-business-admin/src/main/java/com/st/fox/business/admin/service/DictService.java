package com.st.fox.business.admin.service;

import java.util.List;

import com.st.fox.business.admin.domain.Dict;
import com.st.fox.commons.base.page.PageBean;
import com.st.fox.commons.base.page.PageParams;

public interface DictService {

	/**
	 * 字典列表数据
	 */
	PageBean<Dict> findAll(PageParams pageParams, Dict dict);

	/**
	 * 得到字典列表
	 */
	List<Dict> getAllList();

	/**
	 * 通过id 获取字典
	 */
	Dict findById(Integer id);

	/**
	 * 通过type 获取字典
	 */
	List<Dict> getDictList(String type);

	/**
	 * 保存更新字典信息
	 */
	Dict saveOrUpdate(Dict dict);

	/**
	 * 字典删除
	 */
	boolean delById(Integer id);

}
