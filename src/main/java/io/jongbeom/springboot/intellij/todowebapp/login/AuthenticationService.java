package io.jongbeom.springboot.intellij.todowebapp.login;


import org.springframework.stereotype.Service;

//비즈니스 로직을 가졌기에 서비스로 분류
@Service
public class AuthenticationService {
    public boolean authenticate(String username,String password){

        //하드코딩으로 정해진 아이디 비밀번호로 로그인
        boolean isValidUserName = username.equalsIgnoreCase("jongbeom");
        boolean isValidPassword = password.equalsIgnoreCase("1q2w3e4r");

        return isValidUserName&&isValidPassword;
    }

}

