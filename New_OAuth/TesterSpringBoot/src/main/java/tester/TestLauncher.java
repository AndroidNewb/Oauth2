package tester;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class TestLauncher implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TestLauncher.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		/* RestTemplate restTemplate = new RestTemplate();
		 OLBUserInfo user=restTemplate.getForObject("http://localhost:9000/oauth/getuserinfo/dennis", OLBUserInfo.class);
		 
		 System.out.println(user.getAccountNo()+" | "+user.getBalance());*/
		
		
		
		
        System.out.println(new BCryptPasswordEncoder().encode("jack"));
        System.out.println(new BCryptPasswordEncoder().encode("peter"));
        //System.out.println(new BCryptPasswordEncoder().encode("abcd1234"));
		
		
	}

	
	
}
