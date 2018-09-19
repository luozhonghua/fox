package com.st.fox.oauth.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @ClassName:  CloudSiteController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: luozhonghua
 * @date:   2018年7月19日 下午3:26:39
 * @version V1.0
 * 
 */
@RestController
public class CloudSiteController {

    @Autowired
    private RestOperations restOperations;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello From Auth-Client!";
    }

    /**
     * 使用RestTemplate传递OAuth令牌
     * 之前我们在客户端应用程序中定义了一个OAuth2RestTemplate 类型的restOperations bean。
     * 因此可以使用OAuth2RestTemplate中的getForObject() 方法来发送带有令牌的请求到受保护的资源服务
     * @return
     */
    @GetMapping("/personInfo")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("personinfo");
        String personResourceUrl = "http://localhost:9000/person";
        mav.addObject("person", restOperations.getForObject(personResourceUrl, String.class));
        return mav;
    }

}
