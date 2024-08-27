package vip.hoode.object;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author mitu2
 */
class ObjectConverterTest {

    @EqualsAndHashCode(callSuper = true)
    @Data
    static class A extends AbstractObjectConverter<A, B> implements Serializable {
        private String name;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    static class B extends AbstractObjectConverter<B, A> implements Serializable {
        private String name;
    }


    @Test
    void testCase() {
        A a = new A();
        a.setName("is a");
        B b = a.toView();
        assertEquals(a.getName(), b.getName());
    }

}