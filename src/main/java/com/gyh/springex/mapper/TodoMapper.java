package com.gyh.springex.mapper;

import com.gyh.springex.domain.TodoVo;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVo todoVo);

    List<TodoVo> selectAll();


}
