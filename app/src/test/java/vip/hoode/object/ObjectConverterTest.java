package vip.hoode.object;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mitu2
 */
class ObjectConverterTest {

    @EqualsAndHashCode(callSuper = true)
    @Data
    static class A extends AbstractObjectConverter<B> implements Serializable {
        private String name;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    static class B extends AbstractObjectConverter<A> implements Serializable {
        private String name;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    static class C extends AbstractDeepObjectConverter<A> implements Serializable {
        private int age;
        private String name;
    }


    @Test
    void testCase() {
        A a = new A();
        a.setName("Example");
        B b = a.toTarget();
        assertEquals(a.getName(), b.getName());
    }

    @Test
    void testDeepCase() {
        A a = new A();
        a.setName("Example");
        C c = new C();
        c.setAge(10);
        c.fill(a);
        assertEquals(a.getName(), c.getName());
    }

}