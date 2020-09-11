package com.example.stockapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NetworkClient {

	public static Retrofit retrofit;

	public static Retrofit getRetrofit() {

		if (retrofit == null) {
			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			OkHttpClient okHttpClient = builder.build();


			Gson gson = new GsonBuilder()
					.setLenient()
					.create();

			retrofit = new Retrofit.Builder()
					.baseUrl("https://mp-android-challenge.herokuapp.com/")
					.addConverterFactory(ScalarsConverterFactory.create())
					.addConverterFactory(GsonConverterFactory.create(gson))
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.client(okHttpClient)
					.build();

		}

		return retrofit;
	}

}
