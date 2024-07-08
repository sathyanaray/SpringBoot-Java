package com.sathya.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sathya.app.model.Alien;
import com.sathya.app.model.Laptop;
import com.sathya.app.service.LaptopService;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(SpringBootDemoApplication.class, args);
		
	LaptopService service=context.getBean(LaptopService.class);
	Laptop laptop=context.getBean(Laptop.class);
	service.add(laptop);
	
	
	
//		Alien obj=context.getBean(Alien.class);
//		System.out.println(obj.getAge());
//		obj.code();
	}

}
