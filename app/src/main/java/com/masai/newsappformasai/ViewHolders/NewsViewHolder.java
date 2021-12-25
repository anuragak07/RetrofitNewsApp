package com.masai.newsappformasai.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.newsappformasai.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle,tvSubTitle;
    public ImageView iv_headlines;
    public CardView cardView;
    public TextView tvSource;
    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle =itemView.findViewById(R.id.tvvNewsHading);
        tvSubTitle=itemView.findViewById(R.id.tvSubHeading);
        iv_headlines =itemView.findViewById(R.id.ivNews);
        cardView=itemView.findViewById(R.id.main_Container);
        tvSource =itemView.findViewById(R.id.tvSource);
    }
}
