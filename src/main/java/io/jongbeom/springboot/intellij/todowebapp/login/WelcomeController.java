package io.jongbeom.springboot.intellij.todowebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    // http://localhost:8080/login로 갔을 때 출력
    // io.jongbeom.springboot.intellij.todowebapp.login.LoginController로 리디렉션(사용자가 처음 요청한 URL이 아닌, 다른 URL로 자동으로 이동시키는 기술)
    // login.jsp 파일로 컨텐츠 표시
    // MVC - Model : 컨트롤러에서 jsp로 전달하려 할 때 그것을 모델에 넣어서 전달
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String gotoWelcomePage(ModelMap model){
        model.put("name",getLoggedinUsername());
        return "welcome";
    }
    
    // 스프링 세큐리티 이용한 유저명 호출
    private String getLoggedinUsername(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication(); //현재 인증된 주체를 저장
        return authentication.getName();
    }



}
