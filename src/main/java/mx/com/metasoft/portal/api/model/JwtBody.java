package mx.com.metasoft.portal.api.model;

import java.util.List;
import lombok.*;

@Data
public class JwtBody {
    private int userId;
    private String mail;
    private long creation;
    private List<String> roles;
}
