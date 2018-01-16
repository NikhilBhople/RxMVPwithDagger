package nikhil.bhople.rxmvpwithdagger.application.dagger;

import com.squareup.picasso.Picasso;

import dagger.Component;
import nikhil.bhople.rxmvpwithdagger.application.ApiInterface;
import nikhil.bhople.rxmvpwithdagger.application.dagger.modules.ApiInterfaceModule;
import nikhil.bhople.rxmvpwithdagger.application.dagger.modules.NetworkModule;


@AppScope
@Component(modules = {NetworkModule.class, ApiInterfaceModule.class})  // what ever dependency you need form module add here
public interface ApplicationComponent {

    ApiInterface getApiInterface();
    Picasso getPicasso();
}
