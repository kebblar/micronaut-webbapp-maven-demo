package mx.com.metasoft.portal.api.config;

import java.io.Serializable;

public class ExampleException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public ExampleException() {
    }

    public ExampleException(String message) {
        super(message);
    }

    public ExampleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExampleException(Throwable cause) {
        super(cause);
    }

    public ExampleException(String message, Throwable cause,
                            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}