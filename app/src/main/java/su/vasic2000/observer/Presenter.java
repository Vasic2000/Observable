package su.vasic2000.observer;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {
    private Model model = new Model();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
//        new RxStuf().run();
    }

    public void buttonTransferClick(String ss) {
        model.setTransferText(ss);
        String st = model.getTransferText();
        getViewState().setButtonValue(st);
    }
}
