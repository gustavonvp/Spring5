package br.training.Spring5.bootstrap;

import br.training.Spring5.domain.Author;
import br.training.Spring5.domain.Book;
import br.training.Spring5.repository.AuthorRepository;
import br.training.Spring5.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Author eric = new Author("Eric" , "Evans");
        Book odd = new Book("Domain Driven Design", "123123213");
        eric.getBooks().add(odd);
        odd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(eric);

        Author rod = new Author("Rod", "Johnson");
        Book  noEJB = new Book("J2EE Development without EJB", "2183912372135");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(rod);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());



    }
}
