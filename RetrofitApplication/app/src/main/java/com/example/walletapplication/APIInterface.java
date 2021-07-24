package com.example.walletapplication;

//import com.example.walletapplication.model.User;
import com.example.walletapplication.model.Currencies;
import com.example.walletapplication.pojo.MultipleResource;
import com.example.walletapplication.pojo.UserList;
import com.example.walletapplication.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {

    @GET("/api/v1/currencies")
    Call<List<Currencies>> doGetCurrencies();

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
