package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositiries.AuthorRepository;
import guru.springframework.spring5webapp.repositiries.BookRepository;
import guru.springframework.spring5webapp.repositiries.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        Author eric = new Author("Eric", "Ewan");
        Book ddd = new Book("Qwerty", "asdewq");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "sssssdddd");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher mm = new Publisher("M&M", "this street", "asd", "MN", "43000");
        Publisher nn = new Publisher("N&N", "that street", "asssd", "MN", "43003");
        Publisher ll = new Publisher("L&L", "the other street", "adddsd", "MN", "43020");

        publisherRepository.save(mm);
        publisherRepository.save(nn);
        publisherRepository.save(ll);

        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
