package nikhil.bhople.rxmvpwithdagger.application.dagger.modules;

import dagger.Module;
import dagger.Provides;
import nikhil.bhople.rxmvpwithdagger.application.ApiInterface;
import nikhil.bhople.rxmvpwithdagger.application.dagger.AppScope;
import retrofit2.Retrofit;


/**
 * Created by admin on 12-Jan-18.
 */
@Module(includes = NetworkModule.class)
public class ApiInterfaceModule {

    @Provides
    @AppScope
    public ApiInterface provideApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }


}
