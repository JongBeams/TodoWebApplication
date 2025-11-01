package io.jongbeom.springboot.intellij.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤러 설정
@Controller
public class SayHelloController {

    //"say-hello" => "Hello! What are you learning today"

    // http://localhost:8080/say-hello로 갔을 때 출력
    @RequestMapping("say-hello")
    @ResponseBody   //메시지가 리턴한것을 그대로 브라우저로 리턴하는 어노테이션
    public  String sayHello(){
        return "Hello! What are you learning today";
    }


}
