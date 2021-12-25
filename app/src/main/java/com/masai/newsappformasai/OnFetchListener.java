package com.masai.newsappformasai;

import com.masai.newsappformasai.models.ArticlesItem;

import java.util.List;

public interface OnFetchListener<NewsModel> {
    void onFetchData(List<ArticlesItem> list,String message);
    void onError(String message);
}
/*
jab hum apna retrofit network or apiService interface baante hai to network class use that instance of apiservice and the method
for calling lekin hum onfetchlistener isliye bana rahe hai taki hum apna data mainactivity me fetch kar paye jisme onfetch data , list dega articleitem ki

 */
