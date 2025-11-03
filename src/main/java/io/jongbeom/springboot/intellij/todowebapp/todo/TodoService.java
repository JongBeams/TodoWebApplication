package io.jongbeom.springboot.intellij.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//정적 변수 리스트로 우선 저장
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private  static int todosCount =0;

    static {
        todos.add(new Todo(todosCount++,"jongbeom","자바 백엔드 학습종료", LocalDate.now().plusWeeks(1),false));
        todos.add(new Todo(todosCount++,"jongbeom","풀스텍 프로젝트 완성", LocalDate.now().plusMonths(2),false));
        todos.add(new Todo(todosCount++,"jongbeom","이력서 면접 준비 완료", LocalDate.now().plusMonths(3),false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }

    public void addTodo(String username,String description,LocalDate targetDate,boolean done){
        Todo todo= new Todo(todosCount++,username,description,targetDate,done);
        todos.add(todo);
    }


}
