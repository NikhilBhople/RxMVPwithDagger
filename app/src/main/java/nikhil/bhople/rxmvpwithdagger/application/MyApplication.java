package nikhil.bhople.rxmvpwithdagger.application;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import nikhil.bhople.rxmvpwithdagger.application.dagger.ApplicationComponent;
import nikhil.bhople.rxmvpwithdagger.application.dagger.DaggerApplicationComponent;
import nikhil.bhople.rxmvpwithdagger.application.dagger.modules.ContentModule;

/**
 * Created by admin on 12-Jan-18.
 */

public class MyApplication extends Application {

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    public static MyApplication get(Service service) {
        return (MyApplication) service.getApplication();
    }

    private ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .contentModule(new ContentModule(this))
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
