package com.gyh.springex.mapper;

import com.gyh.springex.controller.TodoDTO.PageRequestDTO;
import com.gyh.springex.domain.TodoVo;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVo todoVo);

    List<TodoVo> selectAll();

    TodoVo selectOne(Long tno);

    void remove(Long tno);

    void update(TodoVo todoVo);

    List<TodoVo> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
