package com.example.stockapp.service;

import com.example.stockapp.model.MyData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkInterface {

	@GET("data")
	Observable<List<MyData>> getCriterium();

}
