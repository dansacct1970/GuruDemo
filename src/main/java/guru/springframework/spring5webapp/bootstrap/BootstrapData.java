package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting ....");

        Publisher siena = new Publisher("Monika Karcheva"
                , "Hauptstrasse", "1232", "Bavaria", "85435");
        publisherRepository.save(siena);

        System.out.println("Publisher count : " + publisherRepository.count());


        Author vazov = new Author("Ivan", "Vazov");

        Book podIgoto = new Book("Pod igoto", "121212");


        addBookToAuthor(vazov, podIgoto);
        addAuthorToBook(podIgoto, vazov);


        setBookToPublisher(podIgoto, siena);
        addBookToPublisher(siena, podIgoto);

        saveFilesToRepository(vazov, podIgoto, siena);

        Author tolkien = new Author("J.F", "Tolkien");
        Book lordOfTheRings = new Book("Lord of the Rings", "121212");

        addBookToAuthor(tolkien, lordOfTheRings);
        addAuthorToBook(lordOfTheRings, tolkien);


        setBookToPublisher(lordOfTheRings, siena);
        addBookToPublisher(siena, lordOfTheRings);

        saveFilesToRepository(tolkien, lordOfTheRings, siena);


        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher Number of Books " + publisherRepository.count());

    }

    private void saveFilesToRepository(Author author, Book book, Publisher publisher) {
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);
    }

    private static void addBookToPublisher(Publisher publisher, Book book) {
        publisher.getBooks().add(book);
    }

    private static void setBookToPublisher(Book book, Publisher publisher) {
        book.setPublisher(publisher);
    }

    private static void addAuthorToBook(Book book, Author author) {
        book.getAuthors().add(author);
    }

    private static void addBookToAuthor(Author author, Book book) {
        author.getBooks().add(book);
    }
}
