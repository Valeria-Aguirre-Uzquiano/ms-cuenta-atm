package bo.edu.ucb.mscuentaatm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCuentaAtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCuentaAtmApplication.class, args);
	}

}
