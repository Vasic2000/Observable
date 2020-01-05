package su.vasic2000.observer;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxEventBus {
    private final PublishSubject<Object> bus = PublishSubject.create();

    public RxEventBus() {

    }

    public void post(@NotNull Object event) {
        if(this.bus.hasObservers()) {
            this.bus.onNext(event);
        }
    }

    public Observable<Object> observable() {
        return this.bus;
    }
}
