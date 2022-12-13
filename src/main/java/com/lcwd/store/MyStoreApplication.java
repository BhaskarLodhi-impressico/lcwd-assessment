package com.lcwd.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lcwd.store.entities.Role;
import com.lcwd.store.respository.RoleRepo;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lcwd.store","security"})
public class MyStoreApplication implements CommandLineRunner {
	
	@Autowired
	private RoleRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(MyStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			Role role1 = Role.builder().roleId("admin").roleName("ROLE_ADMIN").build();
			Role role2 = Role.builder().roleId("normal").roleName("ROLE_NORMAL").build();
			repo.save(role1);
			repo.save(role2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
