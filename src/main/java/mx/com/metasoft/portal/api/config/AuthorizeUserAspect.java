package mx.com.metasoft.portal.api.config;

//import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.InterceptorBean;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
//import javax.inject.Singleton;


@Slf4j
@Singleton
@InterceptorBean(AuthorizedRoles.class) //
public class AuthorizeUserAspect {
    private final JwtHelper jwtHelper;

    //@Value("${security.token.lasts:120}")
    private String stringSecurityTokenLasts = "120";

    public AuthorizeUserAspect(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    /** /
    @Around ("@annotation(authorizedRoles)")
    public Object authorize(ProceedingJoinPoint joinPoint, AuthorizedRoles authorizedRoles) throws Throwable {
        // convierte los mintos recibidos como cadena en 'stringSecurityTokenLasts' a milisegundos:
        long validez = convierte(stringSecurityTokenLasts);

        // Obteniendo el JWT de la invocación:
        Object[] argumentos = joinPoint.getArgs();
        Object cadena = argumentos[0]; // como el método exige un JWT como primer parámetro, el [0] está garantizado
        String jwt = cadena.toString();

        // se valida UNICAMENTE la estructura y la firma:
        this.jwtHelper.valida(jwt); // esto dispara un CustomException si la validación falla

        // Los roles que provienen de la anotacion:
        EnumRoles[] roles = authorizedRoles.value();

        // se obtiene el body del JWT ya como objeto java:
        JwtBody body = this.jwtHelper.bodyToObject(jwt);

        // se valida la caducidad
        long now = System.currentTimeMillis();
        long delta = now - body.getCreation();
        if(delta > validez) throw new CustomException(EnumMessage.TOKEN_EXPIRED);

        // Si el rol en el REST endpoint es ABY_ROLE, está autorizado cualquier ROL:
        for(EnumRoles e : roles) {
            if(e == EnumRoles.ANY_ROLE) return joinPoint.proceed();
        }

        // se obtienen los roles del interior del jwt:
        List<String> rolesBody = body.getRoles();

        // se comparan los Enums con las cadenas de roles
        // y si ninguno hizo match, dispara una excepcion:
        for(EnumRoles e : roles) {
            for(String s : rolesBody) {
                if(e.toString().equals(s)) {
                    return joinPoint.proceed();
                }
            }
        }
        throw new CustomException(EnumMessage.NOT_AUTHORIZED);
    }
    /**/

    private long convierte(String stringSecurityTokenLasts) {
        long minutos = 1000 * 60L;
        try {
            return minutos * Integer.parseInt(stringSecurityTokenLasts);
        } catch (Exception e) {
            //log.error("");
            //log.error("Cannot parse value: " + stringSecurityTokenLasts + " using 60 as default");
            return minutos * 30;
        }
    }

}