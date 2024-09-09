package guru.springframework.bootstrap;

import guru.springframework.domain.Author;
import guru.springframework.domain.Book;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author vazov = new Author("Ivan", "Vazov");

        Book podIgoto = new Book("Pod igoto", "121212");


        vazov.getBooks().add(podIgoto);
        podIgoto.getAuthors().add(vazov);

        authorRepository.save(vazov);
        bookRepository.save(podIgoto);

        Author tolkien = new Author("J.F", "Tolkien");
        Book lordOfTheRings = new Book("Lord of the Rings", "121212");

        tolkien.getBooks().add(lordOfTheRings);
        lordOfTheRings.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lordOfTheRings);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());


    }
}
