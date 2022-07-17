package mx.com.metasoft.portal.api.model;

import lombok.*;

@Data
public class ErrorMessage {
    private String message;
    private String shortMessage;
    private boolean status;
}