
package com.masai.newsappformasai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.masai.newsappformasai.models.ArticlesItem;
import com.squareup.picasso.Picasso;

public class DetailsNewsActivity extends AppCompatActivity {
    ArticlesItem articlesItem;
    TextView txt_title,txt_author,txt_time,txt_content,txt_details;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_news);
        txt_title =findViewById(R.id.tvDetailsTitle);
        txt_author =findViewById(R.id.tvDetailsAuthor);
        txt_time =findViewById(R.id.tvDetailsTime);
        txt_content=findViewById(R.id.tvDetailsContent);
        txt_details=findViewById(R.id.tvDetailsSubTitle);
        img_news=findViewById(R.id.ivDetails_news);

        articlesItem = (ArticlesItem) getIntent().getSerializableExtra("data");

        txt_title.setText(articlesItem.getTitle());
        txt_author.setText(articlesItem.getAuthor());
        txt_details.setText(articlesItem.getDescription());
        txt_time.setText(articlesItem.getPublishedAt());
        txt_content.setText(articlesItem.getContent());
        Picasso.get().load(articlesItem.getUrlToImage()).into(img_news);
    }
}