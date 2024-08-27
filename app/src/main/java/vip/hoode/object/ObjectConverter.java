package vip.hoode.object;

/**
 * @author mitu2
 */
public interface ObjectConverter<Model, View> {

    Model toModel();

    Model toModel(Model target, String... ignoreProperties);

    View toView();

    View toView(View target, String... ignoreProperties);

    void fill(Object source, String... ignoreProperties);

}
