package com.security;

import com.security.entities.Role;
import com.security.entities.User;
import com.security.repositories.RoleRepository;
import com.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecuritydemoApplication implements ApplicationRunner {
    @Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
    @Autowired
	PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SecuritydemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//userRepo.save(new User("sam","111"));
		//userRepo.save(new User("amin","111"));
		//roleRepo.save(new Role("Role_Admin"));
		//roleRepo.save(new Role("Role_User"));
		//userRepo.save(new User("aya",passwordEncoder.encode("pass")));
	}
}
