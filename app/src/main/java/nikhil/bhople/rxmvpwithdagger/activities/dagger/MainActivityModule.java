package nikhil.bhople.rxmvpwithdagger.activities.dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.MainActivityPresenter;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.MainActivityView;

/**
 * Created by admin on 13-Jan-18.
 */
@Module
public class MainActivityModule {
    private final Activity activity;

    public MainActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @MainActivityScope
    public MainActivityView provideView(){
        return new MainActivityView(activity);
    }

    @Provides
    @MainActivityScope
    public MainActivityPresenter getPresenter(MainActivityView view){
        return new MainActivityPresenter(view);
    }
}
