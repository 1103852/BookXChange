package com.BookXChange.Controller;

import com.BookXChange.Model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BookXChange.Services.BookService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookservice;
    
    @GetMapping(path = "/bookupload")
    public String uploadBook(Model model){
        BookModel book = new BookModel();
        model.addAttribute("addBookDetails", book);
        return "book/bookUpload";
    }

   @PostMapping(path = "/processbookupload")
    public String process_uploadBook(@ModelAttribute BookModel book){
        bookservice.addBook(book);
        return "redirect:/book/bookupload";
    }

    @GetMapping(path = "/getAllBooks")
    public String allBooks(Model model){
        model.addAttribute("booksList",bookservice.getAllBooks());
        return "book/allbooks";
    }

}
