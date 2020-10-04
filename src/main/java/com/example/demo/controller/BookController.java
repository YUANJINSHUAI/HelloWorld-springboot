package com.example.demo.controller;

import com.example.demo.repositories.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
//@RequestMapping("/hello")
public class BookController {

    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }

    @RequestMapping("/test")
    public HashMap<String, String> helloWorldTest(){
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "hello json");
        map.put("aa", "bb");
        return map;
    }
}
