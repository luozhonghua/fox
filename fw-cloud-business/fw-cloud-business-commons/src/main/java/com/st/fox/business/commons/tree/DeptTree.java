package com.st.fox.business.commons.tree;

import lombok.Getter;
import lombok.Setter;

import com.st.fox.commons.base.tree.TreeNode;

/**
 * 部门树形结构
 * 
 * @author luozhonghua
 */
@Setter
@Getter
public class DeptTree extends TreeNode {

	private static final long	serialVersionUID	= 2764058970186728117L;

	private String				name;

	private Integer				pos					= 0;

}
