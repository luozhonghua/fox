package com.st.fox.system.server.oauth.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**   
 * @ClassName:  ResourceController
 * @Description:提供一个/usr接口供客户端来获得用户的凭证
 * @author: luozhonghua
 * @date:   2018年7月19日 下午2:47:55
 * @version V1.0
 * 
 */
@RestController
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
      return user;
    }

}