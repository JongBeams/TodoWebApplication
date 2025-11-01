package io.jongbeom.springboot.intellij.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤러 설정
@Controller
public class SayHelloController {


    // http://localhost:8080/say-hello로 갔을 때 출력
    @RequestMapping("say-hello")
    @ResponseBody   //메시지가 리턴한것을 그대로 브라우저로 리턴하는 어노테이션
    public  String sayHello(){
        return "Hello! What are you learning today!";
    }

    // http://localhost:8080/say-hello-html로 갔을 때 출력
    @RequestMapping("say-hello-html")
    @ResponseBody   //메시지가 리턴한것을 그대로 브라우저로 리턴하는 어노테이션
    public  String sayHelloHtml(){
        //가변 문자열로 저장해서 하드 코딩 방식 HTML 띄우기
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> HTML 페이지 연습</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("HTML 페이지 연습");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }


    // 일반적으로 jsp파일은 특정 경로 안에 만들어야 한다.
    // 경로 : /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // 경로 : /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    // 경로 : /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // 경로 : /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
    // http://localhost:8080/say-hello-jsp로 갔을 때 출력
    @RequestMapping("say-hello-jsp")
    public  String sayHelloJsp(){
        return "sayHello";
    }
    //application.properties에 접두어 접미어 설정하여 view 경로 설정
    //spring mvc에 기본 포함된 경로 설정 값에 /src/main/resources/META-INF/resources까지 기본 설정이 되어 있다.
    //접두어
    //spring.mvc.view.prefix=/WEB-INF/jsp/
    //접미어
    //spring.mvc.view.suffix=.jsp



}
