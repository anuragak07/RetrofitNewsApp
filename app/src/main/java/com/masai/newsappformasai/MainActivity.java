package com.masai.newsappformasai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.masai.newsappformasai.Adapters.NewsAdapter;
import com.masai.newsappformasai.Services.RetrofitNetwork;
import com.masai.newsappformasai.models.ArticlesItem;
import com.masai.newsappformasai.models.NewsModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerViewNews;
     NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitNetwork retrofitNetwork = new RetrofitNetwork(this);
        retrofitNetwork.getNewsHeadlines(listener);
    }


    private void showNews(List<ArticlesItem> list) {
        recyclerViewNews = findViewById(R.id.recycler_main);
        recyclerViewNews.setHasFixedSize(true);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(this,list);
        recyclerViewNews.setAdapter(newsAdapter);
    }
    private  final  OnFetchListener<NewsModel> listener =new OnFetchListener<NewsModel>() {
        @Override
        public void onFetchData(List<ArticlesItem> list, String message) {
            showNews(list);
        }

        @Override
        public void onError(String message) {

        }
    };
}