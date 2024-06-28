package spring_basic.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication //내장된 톰캣이라는 웹서버를 띄우면서 스프링부트가 같이 올라온다.

public class HelloSpringApplication {

	public static void main(String[] args) {
		//클래스 이름 변경
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
