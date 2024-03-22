package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.MyController;
import dao.MemberDao;
import service.GetMemberNumService;

@ComponentScan(basePackages = {"dao","service"})
@Configuration
public class ControllerConfig {
	
	@Bean
	public MyController myController() {
		return new MyController();
	}
}
