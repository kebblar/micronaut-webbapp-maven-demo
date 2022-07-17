package mx.com.metasoft.portal.api.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EjemploTest {
    @Test
    public void prueba() {
        Ejemplo e = new Ejemplo();
        int r = e.suma(2,3);
        Assertions.assertEquals(5, r);
    }
}
