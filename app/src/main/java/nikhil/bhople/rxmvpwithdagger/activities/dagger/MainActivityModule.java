package nikhil.bhople.rxmvpwithdagger.activities.dagger;

import android.app.Activity;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.MainActivityPresenter;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.MainActivityView;
import nikhil.bhople.rxmvpwithdagger.application.ApiInterface;

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
    public MainActivityPresenter getPresenter(MainActivityView view, ApiInterface apiInterface, Picasso picasso){
        return new MainActivityPresenter(view,apiInterface,picasso);
    }
}
