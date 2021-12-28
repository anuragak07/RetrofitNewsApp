package com.masai.newsappformasai;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.masai.newsappformasai.Adapters.NewsAdapter;
import com.masai.newsappformasai.Services.RetrofitNetwork;
import com.masai.newsappformasai.models.ArticlesItem;
import com.masai.newsappformasai.models.NewsModel;


import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{
     RecyclerView recyclerViewNews;
     NewsAdapter newsAdapter;
     ProgressDialog progressDialog;
     SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView =findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("wait");
                progressDialog.show();
                RetrofitNetwork retrofitNetwork = new RetrofitNetwork(MainActivity.this);
                retrofitNetwork.getNewsHeadlines(listener);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Fetching data");
        progressDialog.show();

        RetrofitNetwork retrofitNetwork = new RetrofitNetwork(this);
        retrofitNetwork.getNewsHeadlines(listener);
    }


    private void showNews(List<ArticlesItem> list) {
        recyclerViewNews = findViewById(R.id.recycler_main);
        recyclerViewNews.setHasFixedSize(true);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(this,list, this);
        recyclerViewNews.setAdapter(newsAdapter);
    }
    private  final  OnFetchListener<NewsModel> listener =new OnFetchListener<NewsModel>() {
        @Override
        public void onFetchData(List<ArticlesItem> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this,"No Data Found",Toast.LENGTH_SHORT).show();
            }else {
                showNews(list);
                progressDialog.dismiss();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this,"NoValue found",Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    public void OnNewsClicked(ArticlesItem articlesItem) {
        Intent intent = new Intent(MainActivity.this,DetailsNewsActivity.class);
        intent.putExtra("data", articlesItem);
        startActivity(intent);



    }
}