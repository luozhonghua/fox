package com.st.fox.admin.service.domain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.st.fox.admin.service.base.BaseServiceImpl;
import com.st.fox.admin.service.dao.SysAdminGroupDao;
import com.st.fox.admin.service.model.SysAdminGroup;
import com.st.fox.admin.service.util.BeanToMapUtil;
import com.st.fox.admin.service.util.Category;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
@Service
public class SysAdminGroupService extends BaseServiceImpl<SysAdminGroup>{
	@Autowired
	private SysAdminGroupDao sysAdminGroupDao;
	
	@Override
	public Mapper<SysAdminGroup> getMapper() {
		return sysAdminGroupDao;
	}
	/**
	 * 列表
	 * @return
	 */
	public List<Map<String, Object>> getDataList() {
		Example example = new Example(SysAdminGroup.class);
		List<SysAdminGroup> rootSysAdminGroups = sysAdminGroupDao.selectByExample(example);
		Map<String, String> fields = Maps.newHashMap();
		fields.put("cid", "id");
		fields.put("fid", "pid");
		fields.put("name", "title");
		fields.put("fullname", "title");
		List<Map<String, Object>> rawList = Lists.newArrayList();
		rootSysAdminGroups.forEach((m)->{
			rawList.add(BeanToMapUtil.convertBean(m));
		});
		Category cate = new Category(fields, rawList);
		return cate.getList(Integer.valueOf("0"));
	}

}
