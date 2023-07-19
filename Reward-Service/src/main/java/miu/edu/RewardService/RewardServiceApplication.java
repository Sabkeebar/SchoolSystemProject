package miu.edu.RewardService;

import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFormatMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RewardServiceApplication {


	public static void main(String[] args) {

		SpringApplication.run(RewardServiceApplication.class, args);
	}

}
