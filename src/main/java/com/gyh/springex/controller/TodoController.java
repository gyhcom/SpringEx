package com.gyh.springex.controller;

import com.gyh.springex.controller.TodoDTO.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list() {
        log.info("todo List....");
    }

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void register() {
        log.info("Get todo register...");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("post todo register...");
        log.info(todoDTO);
    }


}
