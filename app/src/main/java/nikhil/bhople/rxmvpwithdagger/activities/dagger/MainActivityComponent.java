package nikhil.bhople.rxmvpwithdagger.activities.dagger;

import dagger.Component;
import nikhil.bhople.rxmvpwithdagger.activities.MainActivity;
import nikhil.bhople.rxmvpwithdagger.application.dagger.ApplicationComponent;

/**
 * Created by admin on 13-Jan-18.
 */
@MainActivityScope
@Component(modules = {MainActivityModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
