package com.st.fox.system.gateway;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.st.fox.system.FwGatewayApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FwGatewayApplication.class)
public class FwGatewayApplicationTest {

	@Autowired
	private  StringEncryptor	stringEncryptor;


	@Test
	public void testEnvironmentProperties() {




        System.out.println("=====com.github.liuweijw eZLNwFxeSKENBh1pu/M/rMMB76nxo/RLhWSaSLHa8+0==========="
                + stringEncryptor.decrypt("eZLNwFxeSKENBh1pu/M/rMMB76nxo/RLhWSaSLHa8+0=")) ;

        System.out.println("=====com.github.liuweijw.888888 sKbpJGHz9JZmdydv1WOyAYjyXm2irxc0xYqvQ6VpF31uEw/FVNxYeA==  "
                + stringEncryptor.decrypt("sKbpJGHz9JZmdydv1WOyAYjyXm2irxc0xYqvQ6VpF31uEw/FVNxYeA==")) ;

//           eZLNwFxeSKENBh1pu/M/rMMB76nxo/RLhWSaSLHa8+0=
//                sKbpJGHz9JZmdydv1WOyAYjyXm2irxc0xYqvQ6VpF31uEw/FVNxYeA==
//                        fmVD9Jt6YXP9Q+KBPU8/1cWgKn5WhlGuD10SzFADNz4=
        //fmVD9Jt6YXP9Q+KBPU8/1cWgKn5WhlGuD10SzFADNz4=

        System.out.println("=====   jwt:token:liuweijw  fmVD9Jt6YXP9Q+KBPU8/1cWgKn5WhlGuD10SzFADNz4="
                + stringEncryptor.decrypt(" fmVD9Jt6YXP9Q+KBPU8/1cWgKn5WhlGuD10SzFADNz4=")) ;




		System.out.println("=====encrypt  jwt:token:liuweijw======"
				+ stringEncryptor.encrypt("jwt:token:liuweijw"));



		System.out.println("=====root======"
				+ stringEncryptor.encrypt("root"));




		System.out.println("=====decrypt  jwt:token:liuweijw======"
				+ stringEncryptor.decrypt(stringEncryptor.encrypt("jwt:token:liuweijw")));

		System.out.println("=====encrypt   liuweijw======"
				+ stringEncryptor.encrypt("liuweijw")) ;


		System.out.println("=====decrypt   rC/X/8UBBH2bn9Tgfuu7aw========"
				+ stringEncryptor.decrypt("rC/X/8UBBH2bn9Tgfuu7aw==")) ;


		System.out.println("=====decrypt admin  IVTzs5LDfVEsblAFWFgA9w=========="
				+ stringEncryptor.decrypt("IVTzs5LDfVEsblAFWFgA9w==")) ;




	}

//	 public static void   main(String[] args){
//
//		System.out.println("=====jwt:token:liuweijw======"
//				+ stringEncryptor.encrypt("jwt:token:liuweijw"));
//	}
}
