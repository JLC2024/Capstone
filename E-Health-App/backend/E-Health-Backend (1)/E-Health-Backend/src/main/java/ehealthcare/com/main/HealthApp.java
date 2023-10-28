package ehealthcare.com.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ehealthcare.com.entity.Login;
import ehealthcare.com.repository.LoginRepository;




@SpringBootApplication(scanBasePackages = "ehealthcare.com")
@EntityScan(basePackages = "ehealthcare.com.entity")
@EnableJpaRepositories(basePackages = "ehealthcare.com.repository")


public class HealthApp {

	public static void main(String[] args) {
		SpringApplication.run(HealthApp.class, args);
		System.err.print("Spring boot up!");

	}
	
	@Autowired
	LoginRepository loginRepository;
	
	@PostConstruct
	public void init() {
		Login ll = new Login();
		ll.setEmailid("admin@gmail.com");
		ll.setPassword("admin123");
		ll.setTypeofuser("admin");
		loginRepository.save(ll);
		System.out.println("called...");
	}

}
