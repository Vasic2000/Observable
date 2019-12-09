package su.vasic2000.observer;

import androidx.lifecycle.Observer;

public class RxStuf {
    private Observer<String> getStringObserver() {
        return new Observer<String>() {

            @Override
            public void onChanged(String s) {

            }
        };
    }

    void run() {
        //just();
        //fromIterable();
        //interval();
        //timer();
        //take();
        //skip();
        //map();
        //distict();
        //filter();
        //merge();
        //zip();
        //flatMap();
    }
}
