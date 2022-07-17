package mx.com.metasoft.portal.api.controller;

//import javax.inject.Inject;
import javax.validation.Valid;

import mx.com.metasoft.portal.api.model.domain.Person;
import mx.com.metasoft.portal.api.model.exceptions.ControllerException;
import mx.com.metasoft.portal.api.service.PersonaSvr;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;


@Validated
@Controller("/persons")
public class PersonController {

    @Inject
    private PersonaSvr personSvr;

    @Post()
    public HttpResponse<?> savePerson(@Body @Valid Person person) throws ControllerException {
        this.personSvr.save(person);
        return HttpResponse.status(HttpStatus.CREATED).body("Saved successfully !");
    }

    @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> getPersons() {
        return HttpResponse.status(HttpStatus.OK).body(this.personSvr.findAll());
    }
}