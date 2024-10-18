package com.workshop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.workshop.dto.JournalDto;
import com.workshop.entity.Journal;
import com.workshop.entity.WorkShopUser;
import com.workshop.service.JournalServices;
import com.workshop.service.UserServices;

@SpringBootApplication
@ComponentScan("com.workshop")
public class WorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(UserServices userServices,JournalServices journalServices) {
		return args->{
			WorkShopUser user = new WorkShopUser(0, "amina", "attah", "rue du je sais pas quoi",69000, "lyon", "amina@gmail.com", "1234", "USER");
			WorkShopUser admin = new WorkShopUser(0, "adam", "achahbar", "rue du colonel paul paillole",31200, "toulouse", "adam@gmail.com", "1234", "ADMIN");
			userServices.signUp(user);
			userServices.signUp(admin);
			JournalDto journalDto1 = new JournalDto(new Journal(0,
					"Harcelement de la part d'un utilisateur Facebook",
					"en-cours", "FACEBOOK", "description", "facebook", List.of("screen1.JPG","screen2.JPG"), null)
					,1);
			JournalDto journalDto2 = new JournalDto(new Journal(0,
					"Harcelement de la part d'un utilisateur SNAPSHOT",
					"refusé", "SNAPSHOT", "description", "SNAPSHOT", List.of("screen1.JPG","screen2.JPG"), null)
					,1);
			journalServices.addJournalRepo(journalDto1);
			journalServices.addJournalRepo(journalDto2);
			
		};
	}

}
