package com.gyh.springex.mapper;

import com.gyh.springex.domain.TodoVo;

public interface TodoMapper {
    String getTime();

    void insert(TodoVo todoVo);
}
