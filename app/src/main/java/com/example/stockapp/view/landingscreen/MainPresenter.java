package com.example.stockapp.view.landingscreen;

import com.example.stockapp.model.MyData;
import com.example.stockapp.service.NetworkClient;
import com.example.stockapp.service.NetworkInterface;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

	private MainViewInterface mainViewInterface;

	public MainPresenter(MainViewInterface mainViewInterface) {
		this.mainViewInterface = mainViewInterface;
	}

	@Override
	public void getData() {
		NetworkClient.getRetrofit().create(NetworkInterface.class)
				.getCriterium().subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<List<MyData>>() {
					@Override
					public void onSubscribe(Disposable d) {
						mainViewInterface.showProgressBar();
					}

					@Override
					public void onNext(List<MyData> myData) {
						mainViewInterface.hideProgressBar();
						mainViewInterface.onSuccess(myData);
					}

					@Override
					public void onError(Throwable e) {
						mainViewInterface.hideProgressBar();
						mainViewInterface.onShowError();
					}

					@Override
					public void onComplete() {

					}
				});
	}
}
