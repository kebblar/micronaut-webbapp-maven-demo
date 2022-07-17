package mx.com.metasoft.portal.api.service;

import mx.com.metasoft.portal.api.model.exceptions.ServiceException;
import mx.com.metasoft.portal.api.model.domain.Person;
import mx.com.metasoft.portal.api.model.exceptions.CustomException;
import mx.com.metasoft.portal.api.repository.PersonRepository;
import jakarta.inject.Singleton;
import mx.com.metasoft.portal.api.model.enumerations.EnumMessage;

import java.util.*;

@Singleton
public class PersonaSvrImpl implements PersonaSvr {
    private PersonRepository personRepository;
    
    public PersonaSvrImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person p) throws ServiceException {
        if(p.getAge()>99) throw new CustomException(EnumMessage.BAD_CREDENTIALS);
        return personRepository.save(p);
    }

    @Override
    public Iterable<Person> findAll() {
        Set<Person> caja = new HashSet<>();
        Person p = new Person("gus", 20);
        Person q = new Person("tavo", 21);
        caja.add(p);
        caja.add(q);

        //return caja;
        return personRepository.findAll();
    }

    private String validateBalanceOperation(int number, String input) {
        return "source";
    }
    public static void main(String...argv) {

        List<String> bag = List.of("", "gus", null, "ta vo");

        // Imperative programing
        for (String s : bag) {
            if (s != null) {
                System.out.println(s);
            }
        }

        // versus its functional equivalent
        bag.stream().filter(Objects::nonNull).forEach(System.out::println);
    }
/** /
        bag
                .stream()
                .map(entry -> validateBalanceOperation(1, entry))
                .map(entry -> entry.substring(0,1))
                .filter(String::isBlank)
                .map(entry -> entry.substring(0,1))
                .findFirst();

    }
/**/
}
