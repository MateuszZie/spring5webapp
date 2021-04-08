package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.repositories.BookRepositories;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepositories authorRepositories;
    private BookRepositories bookRepositories;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepository publisherRepository) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Author magdalena = new Author("Magdalena","Szarubka");
        Book love = new Book("How i meet my huband","123124");
        magdalena.getBooks().add(love);
        love.getAuthors().add(magdalena);
        Publisher helios = new Publisher("Helios","Warszawa ogrodwa 25 44-100");

        publisherRepository.save(helios);
        System.out.println("Published books = " + publisherRepository.count());

        love.setPublisher(helios);
        helios.getBooks().add(love);

        authorRepositories.save(magdalena);
        bookRepositories.save(love);
        publisherRepository.save(helios);


        Author mateusz = new Author("Mateusz", "Ziebura");
        Book alone = new Book("Alone in City","12314123123");
        mateusz.getBooks().add(alone);
        alone.getAuthors().add(mateusz);
        alone.setPublisher(helios);
        helios.getBooks().add(alone);

        authorRepositories.save(mateusz);
        bookRepositories.save(alone);
        publisherRepository.save(helios);



        System.out.println("Number of books = " + bookRepositories.count());
        System.out.println("Publisher books = " +helios.getBooks().size());


    }
}
