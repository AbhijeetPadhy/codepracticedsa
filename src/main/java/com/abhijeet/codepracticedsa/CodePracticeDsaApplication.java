package com.abhijeet.codepracticedsa;

import com.abhijeet.codepracticedsa.data.entity.Code;
import com.abhijeet.codepracticedsa.data.entity.Users;
import com.abhijeet.codepracticedsa.data.repository.CodeRepository;
import com.abhijeet.codepracticedsa.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CodePracticeDsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodePracticeDsaApplication.class, args);
	}
}
