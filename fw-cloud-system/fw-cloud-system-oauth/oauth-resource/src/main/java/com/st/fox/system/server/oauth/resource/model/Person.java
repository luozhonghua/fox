package com.st.fox.system.server.oauth.resource.model;

/**   
 * @ClassName:  Person
 * @Description:用户信息对象
 * @author: luozhonghua
 * @date:   2018年7月19日 下午2:43:46
 * @version V1.0
 * 
 */
public class Person {
	private String name;
	private String city;
	private String country;
	private Integer age;
	private String sex;

	public Person(String name, String city, String country, Integer age, String sex) {
		this.name = name;
		this.city = city;
		this.country = country;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
