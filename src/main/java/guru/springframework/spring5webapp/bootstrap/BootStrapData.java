package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class BootStrapData implements CommandLineRunner {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  @Override
  public void run(String... args) throws Exception {
    Publisher publisher = new Publisher();
    publisher.setName("SFG Publishing");
    publisher.setCity("St Petersburg");
    publisher.setState("FL");

    publisherRepository.save(publisher);

    Author eric = new Author("eric", "ericL");
    Book firstBook = new Book("firstBook", "123");

    eric.getBooks().add(firstBook);
    firstBook.getAuthors().add(eric);

    firstBook.setPublisher(publisher);
    publisher.getBooks().add(firstBook);

    authorRepository.save(eric);
    bookRepository.save(firstBook);
    publisherRepository.save(publisher);

    Author rod = new Author("rod", "rodL");
    Book secondBook = new Book("secondBook", "1234");

    rod.getBooks().add(secondBook);
    secondBook.getAuthors().add(rod);
    secondBook.setPublisher(publisher);
    publisher.getBooks().add(secondBook);

    authorRepository.save(rod);
    bookRepository.save(secondBook);
    publisherRepository.save(publisher);

    log.info("started bootstrap");
    log.info("number of books {}", bookRepository.count());
    log.info("publisher number of books: {}", publisher.getBooks().size());
  }
}
