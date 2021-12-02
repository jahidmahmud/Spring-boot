package com.sts.web.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.sts.web.jpa.model.User;
import com.sts.web.jpa.repo.UserRepo;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		ApplicationContext context = SpringApplication.run(Application.class, args);
		UserRepo result = context.getBean(UserRepo.class);
		//create
//		User user=new User();
//		user.setName("Mahmud");
//		user.setCity("Srimangal");
//		user.setStatus("Better");
//		User user2=new User();
//		user2.setName("Khan");
//		user2.setCity("Manikgonj");
//		user2.setStatus("Vary nice");
////		User user3 = result.save(user);
////		System.out.println(user3);
//		List<User> usrlst=new ArrayList<>(); 
//		usrlst.add(user);
//		usrlst.add(user2);
//		Iterable<User> allusr = result.saveAll(usrlst);
//		allusr.forEach(System.out::println);
		
		//Update
//		Optional<User> usrOptional = result.findById(10);
//		User user4 = usrOptional.get();
//		user4.setName("rakib Khan");
//		User res = result.save(user4);
//		System.out.println(res);
		//delete
		//result.deleteById(10);
		
		List<User> allUsers = result.getAllUsers();
		allUsers.forEach(System.out::println);
		List<User> findByCity = result.findByCity("savar");
		findByCity.forEach(System.out::println);
	}

}
