package nikhil.bhople.rxmvpwithdagger.activities.mvp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.List;
import nikhil.bhople.rxmvpwithdagger.R;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.ext.RecipeModel;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.ext.RecyclerviewAdapter;
import nikhil.bhople.rxmvpwithdagger.activities.mvp.ext.Result;

/**
 * Created by admin on 13-Jan-18.
 */

public class MainActivityView extends FrameLayout {

    private Button btn_search;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private EditText edtSearch;


    public MainActivityView(@NonNull Activity context) {
        super(context);

        inflate(getContext(),R.layout.activity_main,this);

        btn_search = findViewById(R.id.btn_search);
        recyclerView = findViewById(R.id.recyclerview);
        edtSearch = findViewById(R.id.edt_query);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");

    }

    public io.reactivex.Observable<Object> observeButton() {
        return RxView.clicks(btn_search);
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showProgressDialog(boolean isShow) {
        if(isShow){
            progressDialog.show();
        }
        else {
            progressDialog.dismiss();
        }
    }

    public void renderResponce(RecipeModel responce, Picasso picasso) {
        if(responce != null){
            List<Result> results = responce.getResults();

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new RecyclerviewAdapter(getContext(),results,picasso));

        }
    }

    public String getSearchString() {
        return edtSearch.getText().toString();
    }
}
