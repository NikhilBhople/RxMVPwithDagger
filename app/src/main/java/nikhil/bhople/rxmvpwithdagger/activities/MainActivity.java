package nikhil.bhople.rxmvpwithdagger.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import nikhil.bhople.rxmvpwithdagger.activities.dagger.DaggerMainActivityComponent;
import nikhil.bhople.rxmvpwithdagger.activities.dagger.MainActivityModule;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.MainActivityPresenter;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.MainActivityView;
import nikhil.bhople.rxmvpwithdagger.application.MyApplication;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityView view;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DaggerMainActivityComponent.builder()
                .applicationComponent(MyApplication.get(this).getComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);

        setContentView(view);

        presenter.onCreate();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
