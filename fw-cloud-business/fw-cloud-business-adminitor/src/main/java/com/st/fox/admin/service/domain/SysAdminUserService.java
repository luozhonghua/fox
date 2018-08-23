package com.st.fox.admin.service.domain;

import com.github.pagehelper.PageHelper;
import com.st.fox.admin.service.model.SysAdminAccess;
import io.swagger.models.auth.In;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import com.st.fox.admin.service.base.BaseServiceImpl;
import com.st.fox.admin.service.contants.Constant;
import com.st.fox.admin.service.dao.SysAdminUserDao;
import com.st.fox.admin.service.model.SysAdminUser;
import com.st.fox.admin.service.util.EncryptUtil;
import com.st.fox.admin.service.util.FastJsonUtils;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;


@Service
public class SysAdminUserService extends BaseServiceImpl<SysAdminUser>{

    static final Logger logger = LoggerFactory.getLogger(SysAdminUserService.class);

	@Autowired
	private SysAdminUserDao sysAdminUserDao;

    @Autowired
    private SysAdminUserService sysAdminUserService;

    @Autowired
    private  SysAdminAccessService sysAdminAccessService;

	@Override
	public Mapper<SysAdminUser> getMapper() {
		return sysAdminUserDao;
	}
	
	/**
	 * 修改密码
	 * @param currentUser 当前登录的用户信息
	 * @param old_pwd
	 * @param new_pwd
	 * @return 修改失败返回错误信息，修改成功返回authKey信息。
	 */
	public String setInfo(SysAdminUser currentUser, String old_pwd, String new_pwd) {
		if (currentUser == null){
			return FastJsonUtils.resultError(-400, "请先登录", null);
		}
		
		if (!StringUtils.isNotBlank(old_pwd)) {
			return FastJsonUtils.resultError(-400, "旧密码必填", null);
		}
		
		if(!StringUtils.isNotBlank(new_pwd)) {
			return FastJsonUtils.resultError(-400, "新密码必填", null);
		}
		
		if (old_pwd.equals(new_pwd)) {
			return FastJsonUtils.resultError(-400, "新旧密码不能一样", null);
		}
		
		if (!currentUser.getPassword().equals(DigestUtils.md5Hex(old_pwd))) {
			return FastJsonUtils.resultError(-400, "原密码错误", null);
		}
		
		if (!currentUser.getPassword().equals(DigestUtils.md5Hex(old_pwd))) {
			return FastJsonUtils.resultError(-400, "原密码错误", null);
		}
		SysAdminUser record = new SysAdminUser();
		record.setId(currentUser.getId());
		String md5NewPwd = DigestUtils.md5Hex(new_pwd);
		record.setPassword(md5NewPwd);
		sysAdminUserDao.updateByPrimaryKeySelective(record);
		String authKey = EncryptUtil.encryptBase64(currentUser.getUsername()+"|"+md5NewPwd, Constant.SECRET_KEY);
		//@TODO 更新缓存中auth_key
		return FastJsonUtils.resultError(200, "修改成功", authKey);
	}

	public PageInfo<SysAdminUser> getDataList(SysAdminUser record) {
        if(record.getPage()!=null && record.getRows()!=null) {
             PageHelper.startPage(record.getPage(), record.getRows());
        }
        List<SysAdminUser> list= sysAdminUserDao.selectAll();
        return   new PageInfo<SysAdminUser>(list);
		//return super.selectPage(record.getPage(), record.getRows(), record);
	}

	//save & update  user
	public int updateOrSaveUser(SysAdminUser record){
        Integer userId=null;//控制access
        Integer updateCount=null;
        StringBuilder sb = new StringBuilder();
        SysAdminAccess access = new SysAdminAccess();
	    try {
            logger.info("=====id:"+record.getId());
            if(null==record.getId()){
                //规定密码由个人更改，系统管理员无权更改
                String md5NewPwd = DigestUtils.md5Hex(record.getPassword());
                record.setPassword(md5NewPwd);
                // record.setCreateTime(new Date().);
                sysAdminUserDao.save(record);
                userId=record.getId();
            }else{
                updateCount= sysAdminUserDao.update(record);
            }
            logger.info("=====userId:"+userId);
            //////处理access中间表逻辑
            for(int i = 0;i<record.getGroups().length;i++) {  //["15","26"]
                if(i  == 0) {
                    sb.append(record.getGroups()[0]);
                } else {
                    sb.append(",").append(record.getGroups()[i]);
                }
            }

            access.setUserId(record.getId()==null?userId:record.getId());
            access.setGroupIds(sb.toString());
            logger.info(userId+"====="+FastJsonUtils.toString(record.getGroups()));
            sysAdminAccessService.saveOrUpdate(access);
        }catch (Exception e){
	        e.printStackTrace();
	        throw new RuntimeException(e);
        }finally {
            try {
                if(updateCount!=null){
                    return updateCount;
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
        return  userId;
    }

    /**
     * 编辑用户-查询
     * @param id 用户id
     * @return  用户
     */
    public  SysAdminUser selectByUserId(Integer id){
        return   sysAdminUserDao.findByUserId(id);
    }


    /**
     * 删除用户和用户角色表
     * @param userId
     * @return
     */
    public  int deleteUserAndAccess(Integer userId){
        int flag=0;
        try {
            flag= sysAdminUserDao.deleteUser(userId);
            logger.info("flag1="+flag);
            flag= sysAdminAccessService.delete(userId);
            logger.info("flag2="+flag);
        }catch (Exception e){
           e.printStackTrace();
        }
        return flag;
    }
}
