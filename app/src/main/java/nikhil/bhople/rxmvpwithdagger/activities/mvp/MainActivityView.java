package nikhil.bhople.rxmvpwithdagger.activities.mvp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;

import nikhil.bhople.rxmvpwithdagger.R;

/**
 * Created by admin on 13-Jan-18.
 */

public class MainActivityView extends FrameLayout {

    private Button btn_search;

    public MainActivityView(@NonNull Activity context) {
        super(context);

        inflate(getContext(),R.layout.activity_main,this);

        btn_search = findViewById(R.id.btn_search);
    }

    public io.reactivex.Observable<Object> observeButton() {
        return RxView.clicks(btn_search);
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
