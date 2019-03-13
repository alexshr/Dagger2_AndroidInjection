package ru.startandroid.androidinjector.first;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import ru.startandroid.androidinjector.R;
import ru.startandroid.androidinjector.common.Constants;
import ru.startandroid.androidinjector.second.SecondActivity;

public class FirstActivity extends AppCompatActivity {

    @Inject
    FirstActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        ButterKnife.bind(this);

        Log.d("dagger", "first presenter " + presenter);
    }

    @OnClick(R.id.go)
    void onGoClick() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Constants.EXTRA_DATA, "some data");
        startActivity(intent);
    }
}
