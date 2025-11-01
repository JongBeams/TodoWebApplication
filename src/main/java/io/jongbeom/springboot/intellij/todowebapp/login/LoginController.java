package io.jongbeom.springboot.intellij.todowebapp.login;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
    
    //어플리케이션에서 로깅하는 방법
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    // http://localhost:8080/login?name=Jongbeom로 갔을 때 출력
    // io.jongbeom.springboot.intellij.todowebapp.login.LoginController로 리디렉션(사용자가 처음 요청한 URL이 아닌, 다른 URL로 자동으로 이동시키는 기술)
    // login.jsp 파일로 컨텐츠 표시
    // MVC - Model : 컨트롤러에서 jsp로 전달하려 할 때 그것을 모델에 넣어서 전달
    @RequestMapping("login")
    public  String gotoLoginPage(@RequestParam String name, ModelMap model){//메소드 파라미터가 웹 요청 파라미너테 바잉딩되어야한다는것을 표시
        model.put("name",name); //속성,값
        //System.out.println("Requset Param is "+ name);// 권장되는 방식 아님. 작동 테스용 - URL ?name=Jongbeom 입력 시 Requset Param is Jongbeom 출력됨
        logger.debug("Requset Param is {}",name); //디버그로 분류되어 로그에 표시
        logger.info("I want this printed at info level "); //레벨 단계별 출력문 만들어보기
        logger.warn("I want this printed at warn level ");
        //2025-11-01T20:31:45.493+09:00 DEBUG 24716 --- [todowebapp] [nio-8080-exec-1] i.j.s.i.t.login.LoginController : Requset Param is jongbeom
        return "login";
    }

}
