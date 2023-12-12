package com.omarE505.SpringBootJourney.init;

import com.omarE505.SpringBootJourney.model.Author;
import com.omarE505.SpringBootJourney.model.Book;
import com.omarE505.SpringBootJourney.repositories.AuthorRepository;
import com.omarE505.SpringBootJourney.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringDataInit implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public SpringDataInit(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Omar", "Emad");
        Book book = new Book("Harry Potter", "4387294732");

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Author author2 = new Author("Test", "Name");
        Book book2 = new Book("Test Book", "AnyCode123");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Initializing objects...");
        System.out.println("Number of books : "+ bookRepository.count());
        System.out.println("Number of authors : "+ authorRepository.count());
    }
}
