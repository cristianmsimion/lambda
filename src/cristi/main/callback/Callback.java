package cristi.main.callback;

/**
 * Created by cristian on 02.12.2017.
 */
public interface Callback {

    void error(Exception e);

    Object returnValue(Object o);


}
