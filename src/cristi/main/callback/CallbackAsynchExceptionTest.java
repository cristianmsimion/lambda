package cristi.main.callback;

/**
 * Created by cristian on 03.12.2017.
 */
public class CallbackAsynchExceptionTest extends AsynchCallback {


    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            throw new Exception("test CallbackAsynchExceptionTest");
        } catch (Exception e) {
            error(e);
        }
    }
}
