package su.vasic2000.observer;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Model {
    private String transferText;

    public void setTransferText(String s) {
        transferText = s;
    }

    public String getTransferText() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return transferText;
    }



    public Observable<String> getData() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getTransferText();
            }
        }).subscribeOn(Schedulers.io());
    }

}
