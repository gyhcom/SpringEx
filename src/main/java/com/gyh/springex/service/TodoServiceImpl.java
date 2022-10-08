package com.gyh.springex.service;

import com.gyh.springex.controller.TodoDTO.PageRequestDTO;
import com.gyh.springex.controller.TodoDTO.PageResponseDTO;
import com.gyh.springex.controller.TodoDTO.TodoDTO;
import com.gyh.springex.domain.TodoVo;
import com.gyh.springex.mapper.TodoMapper;
import com.sun.tools.javac.comp.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVo> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }


    @Override
    public TodoDTO getOne(Long tno) {
        TodoVo todoVo = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVo, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper.remove(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVo todoVo = modelMapper.map(todoDTO, TodoVo.class);
        todoMapper.update(todoVo);
    }


}
