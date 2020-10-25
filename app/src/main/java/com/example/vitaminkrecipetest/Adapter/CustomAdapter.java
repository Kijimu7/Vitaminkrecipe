package com.example.vitaminkrecipetest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vitaminkrecipetest.R;
import com.example.vitaminkrecipetest.model.Hits;
import com.example.vitaminkrecipetest.model.Recipe;
import com.example.vitaminkrecipetest.model.Result;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Hits> dataList;
    private Context context;

    public CustomAdapter(Context context, List<Hits> dataList){
        this.context = context;
        this.dataList = new ArrayList<>();

    }

    public void addAll(List<Hits> hits) {
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView){
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtTitle.setText((CharSequence) dataList.get(position).getLable().getImage());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getImage())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount(){
        return dataList.size();
    }
}
