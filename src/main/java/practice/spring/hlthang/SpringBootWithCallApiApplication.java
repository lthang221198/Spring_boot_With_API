package practice.spring.hlthang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("pratice.spring.hlthang.mapper")
@SpringBootApplication
public class SpringBootWithCallApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithCallApiApplication.class, args);
	}

}
