package config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();	//객체 생성
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");	//드라이버 사용
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");  //url 지정, 캐릭터셋 utf8 
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
}
