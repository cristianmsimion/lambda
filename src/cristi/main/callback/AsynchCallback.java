package cristi.main.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cristian on 02.12.2017.
 */
public abstract class AsynchCallback implements Callback, Runnable {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public AsynchCallback() {
        execute();
    }

    @Override
    public void error(Exception e) {
        executorService.shutdown();
    }

    @Override
    public Object returnValue(Object o) {
        executorService.shutdown();
        return o;
    }



    protected void execute(){
        executorService.submit(this);
    }
}
