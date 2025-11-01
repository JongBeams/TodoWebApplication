package io.jongbeom.springboot.intellij.todowebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;


    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    // http://localhost:8080/login로 갔을 때 출력
    // io.jongbeom.springboot.intellij.todowebapp.login.LoginController로 리디렉션(사용자가 처음 요청한 URL이 아닌, 다른 URL로 자동으로 이동시키는 기술)
    // login.jsp 파일로 컨텐츠 표시
    // MVC - Model : 컨트롤러에서 jsp로 전달하려 할 때 그것을 모델에 넣어서 전달
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public  String gotoLoginPage(){
        return "login";
    }

    //로그인 성공 시 페이지 변경
    //쿼리 파라미터와 양식데이터에 @RequsetParam 활용
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String gotoWelcomePage
    (@RequestParam String name, @RequestParam String password, ModelMap model){//로그인 페이지에서 받은 ID 비밀번호를 받아 모델맵에 저장
        //하드코딩으로 인증모드 구현
        //ID jongbeom
        //pw 1q2w3e4r
        if(authenticationService.authenticate(name,password)){

            //뷰(JSP)에 넘길 데이터(모델 속성)를 넣는 동작
            model.put("name",name);
            //model.put("password",password);

            return "welcome";
        }
        model.put("errorMessage","로그인에 실패했습니다. 다시 시도해주세요.");
        //로그인 실패시 로그인 페이지 유지
        return "login";
    }



}
