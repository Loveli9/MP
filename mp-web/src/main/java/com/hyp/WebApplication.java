package com.hyp;

import com.hyp.config.testConfig.Car;
import com.hyp.config.testConfig.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//(exclude={org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,org.activiti.spring.boot.SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Autowired
	private Car car;

	@Autowired
	private Driver driver;

	public void contextLoads() {
		boolean result = driver.getCar() == car;
		System.out.println(result ? "同一个car" : "不同的car");
	}

}
