package com.st.fox.system.api.hystrix;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.st.fox.system.api.PermissionFeignApi;
import com.st.fox.system.api.model.AuthPermission;

@Slf4j
@Service
public class PermissionFeignApiHystrix implements PermissionFeignApi {

	@Override
	public Set<AuthPermission> findMenuByRole(String roleCode) {
		log.error("调用{}异常:{}", "findMenuByRole", roleCode);
		return null;
	}

}
