package su.vasic2000.observer;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import timber.log.Timber;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {
    private Model model = new Model();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void buttonTransferClick(String ss) {
        model.setTransferText(ss);
        getViewState().showLoading();
        model.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Timber.d("OnSubscribe");
                    }

                    @Override
                    public void onNext(String strings) {
                        Timber.d("OnNext");
                        String st = model.getTransferText();
                        getViewState().setButtonValue(st);
                        getViewState().hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "Error ");
                    }

                    @Override
                    public void onComplete() {
                        Timber.d("OnComplete");
                    }
                });
    }
}
