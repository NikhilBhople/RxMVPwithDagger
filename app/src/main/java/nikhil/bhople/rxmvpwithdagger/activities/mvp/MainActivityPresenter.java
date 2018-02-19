package nikhil.bhople.rxmvpwithdagger.activities.mvp;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.ext.RecipeModel;
import nikhil.bhople.rxmvpwithdagger.application.ApiInterface;

/**
 * Created by admin on 13-Jan-18.
 */

public class MainActivityPresenter {

    private final MainActivityView view;
    private ApiInterface apiInterface;
    private Picasso picasso;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public MainActivityPresenter(MainActivityView view, ApiInterface apiInterface, Picasso picasso) {
        this.view = view;
        this.apiInterface = apiInterface;
        this.picasso = picasso;
    }

    public void onCreate() {
        mCompositeDisposable.add(observeButtonClick());

    }

    private Disposable observeButtonClick() {
        return view.observeButton()
                .subscribe(__ -> doApiCall());
    }

    private void doApiCall() {
        HashMap<String, String> params = new HashMap<>();
        params.put("q", view.getSearchString());
        Observable<RecipeModel> recipeList = apiInterface.getRecipeList(params);
        view.showProgressDialog(true);

        recipeList.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showProgressDialog(false))
                .subscribe(responce -> view.renderResponce(responce, picasso),
                        error -> {
                            view.showMessage(error.getMessage());
                        });
    }

    public void onDestroy() {
        mCompositeDisposable.clear();
    }

}
