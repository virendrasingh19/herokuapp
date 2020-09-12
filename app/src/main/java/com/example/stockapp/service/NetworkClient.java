package com.example.stockapp.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

	public static Retrofit retrofit;

	public static Retrofit getRetrofit() {

		if (retrofit == null) {
			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			OkHttpClient okHttpClient = builder.build();


			retrofit = new Retrofit.Builder()
					.baseUrl("https://mp-android-challenge.herokuapp.com/")
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.client(okHttpClient)
					.build();

		}

		return retrofit;
	}

}
