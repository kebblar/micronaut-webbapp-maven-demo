package mx.com.metasoft.portal.api.config;

import mx.com.metasoft.portal.api.model.enumerations.EnumRoles;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizedRoles {
    public EnumRoles[] value();
}*/

import io.micronaut.aop.Around;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@Around
public @interface AuthorizedRoles {
    public EnumRoles[] value();
}