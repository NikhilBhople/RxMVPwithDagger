package nikhil.bhople.rxmvpwithdagger.activities.mvp;

import io.reactivex.disposables.Disposable;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by admin on 13-Jan-18.
 */

public class MainActivityPresenter {

    private final MainActivityView view;
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void onCreate(){
     //   compositeSubscription.add(observeButtonClicks());
    }

    public void onDestroy(){
        compositeSubscription.clear();
    }

    private Disposable observeButtonClicks(){
        return view.observeButton()
                .subscribe(clickevent -> {
                    view.showMessage("Button is clicked");
                });
    }
}
