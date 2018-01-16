package nikhil.bhople.rxmvpwithdagger.activities.mvp.ext;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 12-Jan-18.
 */
public class RecipeModel implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    public final static Parcelable.Creator<RecipeModel> CREATOR = new Creator<RecipeModel>() {


        @SuppressWarnings({"unchecked"})
        public RecipeModel createFromParcel(Parcel in) {
            return new RecipeModel(in);
        }

        public RecipeModel[] newArray(int size) {
            return (new RecipeModel[size]);
        }

    };

    private RecipeModel(Parcel in) {
        in.readList(this.results, (Result.class.getClassLoader()));
    }

    public RecipeModel() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }

}

