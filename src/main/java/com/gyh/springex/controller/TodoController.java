package com.gyh.springex.controller;

import com.gyh.springex.controller.TodoDTO.TodoDTO;
import com.gyh.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

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
    public String registerPost(@Valid TodoDTO todoDTO, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        log.info("post todo register...");

        if(bindingResult.hasErrors()){
            log.info("has errors....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }


}
