package com.gyh.springex.service;

import com.gyh.springex.controller.TodoDTO.PageRequestDTO;
import com.gyh.springex.controller.TodoDTO.PageResponseDTO;
import com.gyh.springex.controller.TodoDTO.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Test....")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();
        todoService.register(todoDTO);
    }

    @Test
    public void testPaging(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        log.info(responseDTO);
        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }
}