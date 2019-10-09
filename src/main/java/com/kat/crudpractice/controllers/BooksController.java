package com.kat.crudpractice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kat.crudpractice.models.Book;
import com.kat.crudpractice.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    @RequestMapping("/books/{id}")
    public String index(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/viewBook.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/newBook.jsp";
    }
}