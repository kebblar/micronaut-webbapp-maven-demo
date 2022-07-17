package mx.com.metasoft.portal.api.service;

import mx.com.metasoft.portal.api.model.exceptions.ServiceException;
import mx.com.metasoft.portal.api.model.domain.Person;

public interface PersonaSvr {
    Person save(Person p) throws ServiceException;
    Iterable<Person> findAll();
}
