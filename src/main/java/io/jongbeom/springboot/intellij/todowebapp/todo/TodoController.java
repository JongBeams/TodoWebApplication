package io.jongbeom.springboot.intellij.todowebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    // 로그인 성공시 하이퍼링크 클릭으로 사용
    @RequestMapping("list-todos")
    public String lisAllTodos(ModelMap model){
        List<Todo> todos =todoService.findByUserName("jongbeom");
        model.addAttribute("todos",todos);

        return "listTodos";
    }

    //투두 리스트 추가
    // http://localhost:8080/add-todo로 갔을 때 출력
    // http://localhost:8080/list-todos에서 버튼으로 이동
    //GET,POST 메소드 추가
    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description,ModelMap model){
        String name = (String) model.get("name");
        todoService.addTodo(name,description, LocalDate.now().plusWeeks(1),false);
        return "redirect:list-todos"; //로직 중복을 막기위한 리디렉션 사용 (URL로 호출해야한다.)
    }

    // 요청 모델 세션
}
