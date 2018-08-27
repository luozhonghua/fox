package com.st.fox.admin.service.domain;

import com.st.fox.admin.service.model.SysAdminMenu;
import com.st.fox.admin.service.model.SysAdminRule;
import com.st.fox.admin.service.model.SysAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luozhonghua on 2018/8/17.
 */

@Service
public class SysLoginService   {

    @Autowired
    private SysAdminRuleService sysAdminRuleService;
    @Autowired
    private SysAdminMenuService sysAdminMenuService;

    public Map<String, Object> retunRuleAndMenu(Map<String, Object> data,SysAdminUser adminUser){
        Map<String, Object> errerMap=new HashMap<String, Object>();
        List<SysAdminRule> rulesTreeList = sysAdminRuleService.getTreeRuleByUserId(adminUser.getId());
        if(null==rulesTreeList ){
            errerMap.put("rerror","帐号角色权限限制");
            return  errerMap;
        }
        List<String> rulesList = sysAdminRuleService.rulesDeal(rulesTreeList);
        if(null==rulesList){
            errerMap.put("rerror","帐号规则授权限制");
            return  errerMap;
        }
        List<SysAdminMenu> menulist= sysAdminMenuService.getTreeMenuByUserId(adminUser.getId());
        if(null==menulist){
            errerMap.put("rerror","帐号菜单授权限制");
            return  errerMap;
        }
        data.put("rulesList", rulesList);
        data.put("menusList",menulist );
        return  data;
    }

}
