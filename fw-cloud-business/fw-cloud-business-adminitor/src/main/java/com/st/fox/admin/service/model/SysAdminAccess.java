package com.st.fox.admin.service.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.st.fox.admin.service.base.BaseEntity;

@Table(name = "`sys_admin_access`")
public class SysAdminAccess extends BaseEntity {
	private static final long serialVersionUID = 7046525700737221455L;

	@Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`group_id`")
    private Integer groupId;

    @Column(name = "`group_ids`")
    private  String groupIds;

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    /**
     * 角色名称
     */
    @Transient
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}