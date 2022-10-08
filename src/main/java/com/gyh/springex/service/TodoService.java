package com.gyh.springex.service;

import com.gyh.springex.controller.TodoDTO.PageRequestDTO;
import com.gyh.springex.controller.TodoDTO.PageResponseDTO;
import com.gyh.springex.controller.TodoDTO.TodoDTO;
import com.gyh.springex.domain.TodoVo;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

    //List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
