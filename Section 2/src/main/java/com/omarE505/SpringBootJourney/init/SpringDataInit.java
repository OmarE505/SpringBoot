package com.omarE505.SpringBootJourney.init;

import com.omarE505.SpringBootJourney.model.Author;
import com.omarE505.SpringBootJourney.model.Book;
import com.omarE505.SpringBootJourney.model.Publisher;
import com.omarE505.SpringBootJourney.repositories.AuthorRepository;
import com.omarE505.SpringBootJourney.repositories.BookRepository;
import com.omarE505.SpringBootJourney.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringDataInit implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public SpringDataInit(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Omar", "Emad");
        Book book = new Book("Harry Potter", "4387294732");
        Publisher publisher = new Publisher();
        publisher.setCity("Cairo");
        publisher.setName("Mohamed");
        publisher.setAddressLine1("New Cairo, Street x, Building xx");

        publisherRepository.save(publisher);

        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author author2 = new Author("Test", "Name");
        Book book2 = new Book("Test Book", "AnyCode123");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        book2.setPublisher(publisher);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Initializing objects...");
        System.out.println("Number of books : "+ bookRepository.count());
        System.out.println("Number of authors : "+ authorRepository.count());
        System.out.println("Number of publishers : "+ publisherRepository.count());
        System.out.println("Publisher number of books : "+ publisher.getBooks().size());
    }
}
