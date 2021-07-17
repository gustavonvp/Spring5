package br.training.Spring5.repository;

import br.training.Spring5.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Author, Long> {


}
