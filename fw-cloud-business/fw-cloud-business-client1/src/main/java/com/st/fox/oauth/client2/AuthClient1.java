package com.st.fox.oauth.client2;

import com.st.fox.oauth.client2.filters.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**   
 * @ClassName:  Application
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: luozhonghua
 * @date:   2018年7月19日 下午3:21:27
 * @version V1.0
 * 
 */
@SpringBootApplication
public class AuthClient1 {
	public static void main(String[] args) {
        SpringApplication.run(AuthClient1.class, args);
    }    
    
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    }
}
