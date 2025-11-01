package io.jongbeom.springboot.intellij.todowebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
//기본적으로 입력된 정보는 페이지 이동 시 유지되지않는다. 이를 더 길게 유지하려면 세션을 사용해야 한다.
//유지하려는 값을 추가
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    // http://localhost:8080/list-todos로 갔을 때 출력
    @RequestMapping("list-todos")
    public String lisAllTodos(ModelMap model){
        List<Todo> todos =todoService.findByUserName("jongbeom");
        model.addAttribute("todos",todos);

        return "listTodos";
    }

    // 요청 모델 세션
}
