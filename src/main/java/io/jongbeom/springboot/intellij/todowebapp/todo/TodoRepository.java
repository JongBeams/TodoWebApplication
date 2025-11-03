package io.jongbeom.springboot.intellij.todowebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo,Integer> {//관리할 클래스와 ID 필드 타입

    public List<Todo> findByUsername(String username);
    
    
}
