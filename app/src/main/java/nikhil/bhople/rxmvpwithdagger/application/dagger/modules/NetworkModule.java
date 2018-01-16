package nikhil.bhople.rxmvpwithdagger.application.dagger.modules;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import nikhil.bhople.rxmvpwithdagger.application.dagger.AppScope;
import nikhil.bhople.rxmvpwithdagger.extra.Constant;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module (includes = ContentModule.class)
public class NetworkModule {

    @Provides
    @AppScope
    public File provideCacheFile(Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @AppScope
    public Cache provideCache(File cacheFile){
        return new Cache(cacheFile , 10*1000*1000); // creating 10Mb cache
    }

    @Provides
    @AppScope
    public OkHttpClient provideOkhttpClient(Cache cache){
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
        /* we are providing cache file for okhttp because
         it will store network call or image, by this way we can
         optimise the network efficiency  */
    }

    @AppScope
    @Provides
    public Picasso providePicasso(Context context, OkHttpClient okHttpClient){
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

    @Provides
    @AppScope
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(Constant.Base_Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

}
