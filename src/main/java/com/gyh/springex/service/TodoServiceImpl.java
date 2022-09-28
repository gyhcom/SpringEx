package com.gyh.springex.service;

import com.gyh.springex.controller.TodoDTO.TodoDTO;
import com.gyh.springex.domain.TodoVo;
import com.gyh.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVo todoVo = modelMapper.map(todoDTO, TodoVo.class);
        log.info(todoVo);

        todoMapper.insert(todoVo);
    }

}
