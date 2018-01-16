package nikhil.bhople.rxmvpwithdagger.application;

import java.util.HashMap;

import io.reactivex.Observable;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.ext.RecipeModel;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by admin on 12-Jan-18.
 */

public interface ApiInterface {

    @GET("/api")
    Observable<RecipeModel> getRecipeList(@QueryMap HashMap<String,String> params);
}
