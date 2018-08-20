package com.st.fox.admin.service.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.st.fox.admin.service.base.BaseEntity;

import java.util.Date;

@Table(name = "`sys_admin_user`")
public class SysAdminUser  extends BaseEntity {
	private static final long serialVersionUID = -6695722256864729383L;

    /**
     * 管理后台账号
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 管理后台密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 用户备注
     */
    @Column(name = "`remark`")
    private String remark;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`last_time`")
    private Date lastTime;
    /**
     * 真实姓名
     */
    @Column(name = "`realname`")
    private String realname;

    /**
     * 部门
     */
    @Column(name = "`structure_id`")
    private Integer structureId;

    /**
     * 岗位
     */
    @Column(name = "`post_id`")
    private Integer postId;

    /**
     * 状态,1启用0禁用
     */
    @Column(name = "`status`")
    private Byte status;


    /**
     * 部门名称
     */
    @Transient
    private String sname;

    /**
     * 岗位名
     */
    @Transient
    private String pname;

    /**
     * 角色名称
     */
    @Transient
    private String groupName;

    /**
     * 角色ID
     */
    @Transient
    private  Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


    /**
     * 获取管理后台账号
     *
     * @return username - 管理后台账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置管理后台账号
     *
     * @param username 管理后台账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取管理后台密码
     *
     * @return password - 管理后台密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置管理后台密码
     *
     * @param password 管理后台密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户备注
     *
     * @return remark - 用户备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置用户备注
     *
     * @param remark 用户备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取真实姓名
     *
     * @return realname - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取部门
     *
     * @return structure_id - 部门
     */
    public Integer getStructureId() {
        return structureId;
    }

    /**
     * 设置部门
     *
     * @param structureId 部门
     */
    public void setStructureId(Integer structureId) {
        this.structureId = structureId;
    }

    /**
     * 获取岗位
     *
     * @return post_id - 岗位
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * 设置岗位
     *
     * @param postId 岗位
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * 获取状态,1启用0禁用
     *
     * @return status - 状态,1启用0禁用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态,1启用0禁用
     *
     * @param status 状态,1启用0禁用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}