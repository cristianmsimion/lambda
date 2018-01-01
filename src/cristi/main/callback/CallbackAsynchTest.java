package cristi.main.callback;

/**
 * Created by cristian on 02.12.2017.
 */
public class CallbackAsynchTest extends AsynchCallback {


    public void run() {
        String value = "success CallbackAsynchTest";
        try {
            Thread.sleep(3000);
            returnValue(value);
        } catch (InterruptedException e) {
            error(e);
        }
    }

}
