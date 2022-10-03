package com.gyh.springex.service;

import com.gyh.springex.controller.TodoDTO.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();

    TodoDTO getOne(Long tno);
}
