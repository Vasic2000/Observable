package su.vasic2000.observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    Presenter presenter;

    @BindView(R.id.btnTransfer)
    Button buttonOne;
    @BindView(R.id.et_input)
    EditText inputText;
    @BindView(R.id.tv_result)
    TextView outputText;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @ProvidePresenter
    public Presenter createPresenter() {
        return new Presenter();
    }

    @OnClick({R.id.btnTransfer})
    public void onButtonClick() {
        presenter.buttonTransferClick(inputText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void setButtonValue(String s) {
        String k = s;
        outputText.setText(k);
    }

    @Override
    public void showLoading() {
        buttonOne.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
        buttonOne.setVisibility(View.VISIBLE);
    }
}
