package com.masai.newsappformasai.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.newsappformasai.R;
import com.masai.newsappformasai.ViewHolders.NewsViewHolder;
import com.masai.newsappformasai.models.ArticlesItem;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private Context context;
    private List<ArticlesItem> articlesItemList;

    public NewsAdapter(Context context, List<ArticlesItem> articlesItemList) {
        this.context = context;
        this.articlesItemList = articlesItemList;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headlines_list_item,parent,false);
       return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
      holder.tvTitle.setText(articlesItemList.get(position).getTitle());
      holder.tvSubTitle.setText(articlesItemList.get(position).getDescription());
      holder.tvSource.setText(articlesItemList.get(position).getSource().getName());
        Picasso.get().load(articlesItemList.get(position).getUrlToImage()).into(holder.iv_headlines);


    }

    @Override
    public int getItemCount() {
        return articlesItemList.size();
    }
}
