package com.example.stockapp.view.landingscreen;

import com.example.stockapp.model.MyData;

import java.util.List;

public interface MainViewInterface {

	void onShowError(String message);

	void hideProgressBar();

	void showProgressBar();

	void onSuccess(List<MyData> myData);

}
