package nikhil.bhople.rxmvpwithdagger.application.dagger.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import nikhil.bhople.rxmvpwithdagger.application.dagger.AppScope;

/**
 * Created by admin on 12-Jan-18.
 */
@Module
public class ContentModule {

    // it is called as external dependency so each time while building daggerMainComponent we have to provide context

    private final Context context;

    public ContentModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    @AppScope // giving main application custom scope
    public Context provideContext(){
        return context;
    }
}
