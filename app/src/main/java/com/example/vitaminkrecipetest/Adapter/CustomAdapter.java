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
import com.example.vitaminkrecipetest.activity.MainActivity;
import com.example.vitaminkrecipetest.model.Hit;
import com.example.vitaminkrecipetest.model.Result;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Hit> dataList;
    private Context context;
//    public List<Hit> hits;


    public CustomAdapter(List<Hit> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public void addAll(List<Hit> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();


    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView){
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);
        }
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getRecipe().getLabel());


        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getRecipe().getImage())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount(){
        return dataList.size();
    }
}
