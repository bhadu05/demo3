package com.ex.demo3;

import com.ex.demo3.entity.User;
import com.ex.demo3.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class Demo3Application {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init()
	{
		List<User> users = Stream.of(
				new User(1,"user1","pwd1"),
				new User(2,"user2","pwd2")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	public static void main(String[] args) {
		//String str = "first";
		System.out.println("Yes i also output things");
		SpringApplication.run(Demo3Application.class, args);
	}

}
