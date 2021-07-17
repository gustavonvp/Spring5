package br.training.Spring5.bootstrap;

import br.training.Spring5.domain.Author;
import br.training.Spring5.domain.Book;
import br.training.Spring5.domain.Publisher;
import br.training.Spring5.repository.AuthorRepository;
import br.training.Spring5.repository.BookRepository;
import br.training.Spring5.repository.PublisherRepository;
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
    public void run(String... args) throws Exception{

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St petersburg");
        publisher.setState("FL");
        publisher.setZip("2321456");

        publisherRepository.save(publisher);



        Author eric = new Author("Eric" , "Evans");
        Book odd = new Book("Domain Driven Design", "123123213");
        eric.getBooks().add(odd);
        odd.getAuthors().add(eric);

        odd.setPublisher(publisher);
        publisher.getBooks().add(odd);

        authorRepository.save(eric);
        bookRepository.save(eric);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book  noEJB = new Book("J2EE Development without EJB", "2183912372135");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(rod);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());



    }
}
