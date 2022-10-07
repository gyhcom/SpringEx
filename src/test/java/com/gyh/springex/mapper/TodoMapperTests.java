package com.gyh.springex.mapper;

import com.gyh.springex.controller.TodoDTO.PageRequestDTO;
import com.gyh.springex.domain.TodoVo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVo todoVo = TodoVo.builder()
                .title("스프링테스트")
                .dueDate(LocalDate.of(2022,10,10))
                .writer("user00")
                .build();
        todoMapper.insert(todoVo);
    }

    @Test
    public void testSelctAll(){
        List<TodoVo> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSeelctOne(){
        TodoVo todoVo = todoMapper.selectOne(1L);
        log.info(todoVo);
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVo> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }
}
