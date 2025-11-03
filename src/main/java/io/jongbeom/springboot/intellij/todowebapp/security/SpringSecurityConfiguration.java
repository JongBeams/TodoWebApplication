package io.jongbeom.springboot.intellij.todowebapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //LDAP DataBase

    //인메모리 방식으로 진행
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        //더이상 사용되지 않는 코드
        //UserDetails userDeatils = User.withDefaultPasswordEncoder()

        //String 입력 String 출력, 인풋값을 인코딩된 input값으로 변환
        Function<String,String> passwordEncoder =input->passwordEncoder().encode(input);
        UserDetails userDeatils = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("jongbeom")
                .password("1q2w3e4r")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDeatils);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //BCrypt 해싱 알고리즘을 사용한 단방향 암호화 하기
        return new BCryptPasswordEncoder();
    }



}
