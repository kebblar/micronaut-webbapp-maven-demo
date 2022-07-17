package mx.com.metasoft.portal.api.model.exceptions;

import mx.com.metasoft.portal.api.model.enumerations.HttpStatus;

/**
 * <p>Descripción:</p>
 * Excepción general que define que se ha violado una regla de la lógica de negocio.
 *
 * @author  fhernanda
 * @see     io.kebblar.petstore.api.model.exceptions.ServiceException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ServiceException extends ControllerException {
    private static final long serialVersionUID = -1218087669509474484L;

    /**
     * Constructor basado en una excepción.
     *
     * @param e excepción usada por el constructor
     */
    public ServiceException(Exception e) {
        super(e);
    }

    /**
     * <p>Constructor for ServiceException.</p>
     *
     * @param shortMessage a {@link java.lang.String} object.
     * @param detailedMessage a {@link java.lang.String} object.
     * @param localExceptionNumber a int.
     * @param localExceptionKey a {@link java.lang.String} object.
     * @param httpStatus a HttpStatus object.
     */
    public ServiceException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpStatus) {
        super(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey, httpStatus);
    }

    /**
     * <p>Constructor for ServiceException.</p>
     *
     * @param shortMessage a {@link java.lang.String} object.
     * @param detailedMessage a {@link java.lang.String} object.
     * @param localExceptionNumber a int.
     * @param localExceptionKey a {@link java.lang.String} object.
     */
    public ServiceException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey) {
        super(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey);
    }

    /**
     * <p>Constructor for ServiceException.</p>
     *
     * @param shortMessage a {@link java.lang.String} object.
     * @param detailedMessage a {@link java.lang.String} object.
     */
    public ServiceException(
            String shortMessage,
            String detailedMessage) {
        super(shortMessage, detailedMessage, 0, "CVE_0000");
    }

    public ServiceException(
            Throwable throwable,
            String shortMessage,
            String detailedMessage,
            int exceptionNumber,
            String message,
            HttpStatus httpStatus) {
        super(throwable,shortMessage,detailedMessage,exceptionNumber,message,httpStatus);
    }

}