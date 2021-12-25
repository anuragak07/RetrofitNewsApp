package com.masai.newsappformasai.Services;

import android.content.Context;
import android.widget.Toast;

import com.masai.newsappformasai.OnFetchListener;
import com.masai.newsappformasai.models.NewsModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitNetwork {
    private Context context;

    public RetrofitNetwork(Context context) {
        this.context = context;
    }

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build();

        return retrofit;
    }
    //apna api call manage karenge
    public void getNewsHeadlines(OnFetchListener onFetchListener){
        CallNewsApi callNewsApi = getInstance().create(CallNewsApi.class);
        callNewsApi.getNewsResponse().enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context,"Error in fetching data",Toast.LENGTH_LONG).show();
                }

                onFetchListener.onFetchData(response.body().getArticles(), response.message());

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                onFetchListener.onError("Request Failed");

            }
        });
    }
    public  interface CallNewsApi{
        @GET("top-headlines?country=us&apiKey=69b9a56758f04bfab122e54f20b7096c")
        Call<NewsModel> getNewsResponse();

    }

}
