package cristi.main.callble;

import java.util.concurrent.Callable;

/**
 * Created by cristian on 02.12.2017.
 */
public class TestCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "success Test Callable";
    }
}
