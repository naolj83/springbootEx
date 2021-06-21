package springbootex;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Bootstrap Class
 * 
 * 1. 스프링 부트 애플리케이션의 부트스트래핑(Bootstrapping) (Bootstrapping은 wiring하는 것 -> 어플리케이션을 시작하기 위한 모든 준비작업)
 * 2. 설정 클래스(Configuration Class)
 *
 */

// @SpringBootApplication 메타 어노테이션
// - @SpringBootConfiguration(alias for @Configuration)
// - @ComponentScan
// - @AutoConfiguration
//
@SpringBootApplication	// configuration 필수!
public class HelloWorldApplication {	// 부트 스트랩 클래스
	@Bean
	public ApplicationRunner applicationRunner() {
		// 1. 작성된 구현 클래스를 사용
		// return new HelloWorldRunner();
		
		// 2. Anonymouse Class 적용(이름이 없는 class -> 클래스 파일을 만들지 않아도 된다.)
//		return new ApplicationRunner() {
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//				System.out.println("Hello World");
//			}
//			
//		};
		
		// 3. 함수형(람다 표현식)
		return (ApplicationArguments args) -> {
			System.out.println("Hello World");
		};
	}
	
	public static void main(String[] args) {
		/**
		 * version 5 기준
		 * 
		 * 1. 애플리케이션 컨텍스트(Application Context, 컨테이너) 생성
		 * 2. 애플리케이션 타입 결정(Web - Servlet, Reactive)
		 *    (Web Application일 경우에만 결정 -> Stater Dependency에서 Web 인지 아닌지 알 수 있다)
		 * 3. 어노테이션 스캐닝을 통한 빈 생성 및 등록
		 * 4. 웹 애플리케이션인 경우(Web)
		 *	   - 내장(embedded) 서버(TomcatEmbeddedServletContainer - 실행하는 톰캣 클래스) 인스턴스 생성
		 *	   - 서버 인스턴스에 웹 애플리케이션을 배포
		 *	   - 서버 인스턴스 실행
		 * 5. 인터페이스 ApplicationRunner 구현 빈의 run() 실행
		 * 
		 */
		// 설정 클래스가 다 되어야 Auto Configuration 할 수 있음
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
