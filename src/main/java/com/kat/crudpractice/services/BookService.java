package com.kat.crudpractice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kat.crudpractice.models.Book;
import com.kat.crudpractice.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteBook(Long id) {
		
    	bookRepo.deleteById(id);
  
	}
	
    public Book updateBook(Long id, Integer numberOfPages, String title, String language, String description) {
    	Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            optionalBook.get().setNumberOfPages(numberOfPages);
            optionalBook.get().setLanguage(language);
            optionalBook.get().setTitle(title);
            optionalBook.get().setDescription(description);
            bookRepo.save(optionalBook.get());
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
