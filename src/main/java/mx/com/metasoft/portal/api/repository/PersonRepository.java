package mx.com.metasoft.portal.api.repository;

import mx.com.metasoft.portal.api.model.domain.Person;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> { }