package io.jongbeom.springboot.intellij.todowebapp.security;

//정적 메서드만 import
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //LDAP DataBase

    //인메모리 방식으로 진행
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        //더이상 사용되지 않는 코드
        //UserDetails userDeatils = User.withDefaultPasswordEncoder()

        UserDetails userDeatils = createNewUser("jongbeom", "1q2w3e4r");
        UserDetails userDeatils2 = createNewUser("beams", "5242");

        return new InMemoryUserDetailsManager(userDeatils,userDeatils2);
    }


    private UserDetails createNewUser(String jongbeom, String password) {
        //String 입력 String 출력, 인풋값을 인코딩된 input값으로 변환
        Function<String,String> passwordEncoder =input->passwordEncoder().encode(input);
        UserDetails userDeatils = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(jongbeom)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDeatils;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //BCrypt 해싱 알고리즘을 사용한 단방향 암호화 하기
        return new BCryptPasswordEncoder();
    }


    //SecurityFilterChain의 기능
    //모든 URL 보호
    //인증되지 않은 접근 시 로그인 화면으로 이동
    //CSRF 미사용
    //Frames
    @Bean
    //Http ServletRequest에 매칭될 수 있는 필터체인을 정의
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {//웹 기반 보안을 설정하도록 해준다. 기본값으로서 이건 모든 요청에 정용될 것이다.
        //모든 URL 보호
        http.authorizeHttpRequests( //규칙을 설정하는 메서드
                auth->auth.anyRequest().authenticated());  //모든 요청을 인증된 사용자만 사용가능하도록 정의
        http.formLogin(withDefaults());

        //보안관련 스프링 세큐리티 버전 6.1이상에서 지원 중단 및 제거 예정
        //http.csrf().disable();
        //http.headers().frameOptions().disable();

        //람다식으로 변환되어 사용
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));


        return http.build();
    }

    
}
