package nikhil.bhople.rxmvpwithdagger.activities.mvp.ext;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nikhil.bhople.rxmvpwithdagger.R;

/**
 * Created by admin on 16-Jan-18.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private final Context context;
    private final List<Result> results;
    private Picasso picasso;

    public RecyclerviewAdapter(Context context, List<Result> results, Picasso picasso) {

        this.context = context;
        this.results = results;
        this.picasso = picasso;
    }

    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_card,null));
    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.ViewHolder holder, int position) {
        holder.title.setText(results.get(position).getTitle());
        holder.content.setText(results.get(position).getIngredients());

        if(!results.get(position).getThumbnail().equals(""))
        {
            picasso.setIndicatorsEnabled(true);
            picasso.load(results.get(position).getThumbnail()).into(holder.image);
        }
        else {
            picasso.load(R.drawable.ic_launcher_background).into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return results == null ? 0:results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView title, content;
        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.T_title);
            content =  itemView.findViewById(R.id.T_content);
            image = itemView.findViewById(R.id.image);

            itemView.findViewById(R.id.LL_main).setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(results.get(getAdapterPosition()).getHref()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.chrome");
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                context.startActivity(intent);
            }
        }
    }
}

