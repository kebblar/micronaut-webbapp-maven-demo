package mx.com.metasoft.portal.api.model.exceptions;

import mx.com.metasoft.portal.api.model.enumerations.EnumMessage;

/**
 * <p>Descripción:</p>
 * Excepción general que define que se ha violado una regla de la lógica de negocio.
 *
 * @author  fhernanda
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class CustomException extends ServiceException {
    private static final long serialVersionUID = -1218087669509474484L;

    public CustomException(EnumMessage message, Object... messageParams) {
        this(new Exception(), message, messageParams);
    }

    public CustomException(Throwable throwable, EnumMessage message, Object... messageParams) {
        super(throwable,
                String.format(message.getShortMessage(), messageParams),
                String.format(message.getDetailedMessage(), messageParams),
                message.getExceptionNumber(),
                message.toString(),
                message.getHttpStatus());
    }

}