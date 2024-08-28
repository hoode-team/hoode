package vip.hoode.object;

/**
 * @author mitu2
 */
public interface ObjectConverter<Target> {

    Target toTarget();

    Target toTarget(Target target, String... ignoreProperties);

    void fill(Object source, String... ignoreProperties);

}
