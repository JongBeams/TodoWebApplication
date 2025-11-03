package io.jongbeom.springboot.intellij.todowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        //생성 기본값 설정
        String username = (String) model.get("name");
        Todo todo = new Todo(0,username,"기본 설명",LocalDate.now().plusWeeks(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    //commend bean(양식 보조 개체) 폼 데이터를 받아서 처리하는 객체, 사용자가 입력한 데이터를 Java 객체로 자동 매핑해주는 역할
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){// Todo bean 직접 바인딩, 해당 방식을 jsp에서 사용하려면 form 추가 필요
        //Bean을 바인딩 하는 곳에 @Valid 어노테이션 사용 시 바인딩 전 @Size 등의 검증을 하게 된다.

        if(result.hasErrors()){
            return "todo";
        }

        String name = (String) model.get("name");
        todoService.addTodo(name,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos"; //로직 중복을 막기위한 리디렉션 사용 (URL로 호출해야한다.)
    }


    // http://localhost:8080/delete-todo로 갔을 때 출력
    // 로그인 성공시 하이퍼링크 클릭으로 사용
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        // 투두 삭제
        todoService.deleteById(id);
        return "redirect:list-todos";
    }


    // http://localhost:8080/update-todo로 갔을 때 출력
    // 로그인 성공시 하이퍼링크 클릭으로 사용
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodopage(@RequestParam int id,ModelMap model){
        // 투두 변경
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        //todoService.deleteById(id);
        return "todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    //commend bean(양식 보조 개체) 폼 데이터를 받아서 처리하는 객체, 사용자가 입력한 데이터를 Java 객체로 자동 매핑해주는 역할
    public String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result){// Todo bean 직접 바인딩, 해당 방식을 jsp에서 사용하려면 form 추가 필요
        //Bean을 바인딩 하는 곳에 @Valid 어노테이션 사용 시 바인딩 전 @Size 등의 검증을 하게 된다.

        if(result.hasErrors()){
            return "todo";
        }

        String username = (String) model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos"; //로직 중복을 막기위한 리디렉션 사용 (URL로 호출해야한다.)
    }




    // 요청 모델 세션
}
