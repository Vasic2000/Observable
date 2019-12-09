package su.vasic2000.observer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.btnTransfer)
    Button buttonOne;

    @BindView(R.id.et_input)
    EditText inputText;

    @BindView(R.id.tv_result)
    TextView outputText;

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @ProvidePresenter
    public Presenter createPresenter() {
        return new Presenter();
    }

    @OnClick({R.id.btnTransfer})
    public void onButtonClick() {
        presenter.buttonTransferClick(inputText.getText().toString());
    }

    @Override
    public void setButtonValue(String s) {
        String k = s;
        outputText.setText(k);
    }
}
