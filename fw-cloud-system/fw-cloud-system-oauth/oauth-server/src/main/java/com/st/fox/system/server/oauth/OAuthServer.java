package com.st.fox.system.server.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**   
 * @ClassName:  AuthServer
 * @Description:OAuth认证服务
 * @author: luozhonghua
 * @date:   2018年7月19日 下午2:21:34
 * @version V1.0
 * 
 */
@SpringBootApplication
public class OAuthServer {

    public static void main(String[] args) {
        SpringApplication.run(OAuthServer.class, args);
    }
}
