package mx.com.metasoft.portal.api.config;

import mx.com.metasoft.portal.api.model.ErrorMessage;
import mx.com.metasoft.portal.api.model.exceptions.CustomException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {CustomException.class, ExceptionHandler.class })
public class CustomExceptionHandler implements ExceptionHandler<CustomException, HttpResponse<ErrorMessage>> {

    @Override
    public HttpResponse<ErrorMessage> handle(HttpRequest request, CustomException exception) {
        ErrorMessage message = new ErrorMessage();
        message.setMessage(exception.getDetailedMessage());
        message.setShortMessage(exception.getShortMessage());
        message.setStatus(false);
        return HttpResponse.serverError(message).status(translate(exception.getHttpStatus()));
    }

    public HttpStatus translate(mx.com.metasoft.portal.api.model.enumerations.HttpStatus localHttpStsatus) {
        return HttpStatus.valueOf(localHttpStsatus.value());
    }

}