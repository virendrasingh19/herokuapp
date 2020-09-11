package com.example.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.stockapp.databinding.ActivityMainBinding;
import com.example.stockapp.model.MyData;
import com.example.stockapp.view.adapterview.MainAdapter;
import com.example.stockapp.view.adapterview.OnClickInterface;
import com.example.stockapp.view.detailscreen.DetailScreen;
import com.example.stockapp.view.landingscreen.MainPresenter;
import com.example.stockapp.view.landingscreen.MainViewInterface;

import org.parceler.Parcels;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewInterface, OnClickInterface {

	public static final String ARG_DATA = "arg_data";
	private ActivityMainBinding mainBinding;
	private MainPresenter mainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		setupMVP();
		setupViews();
		getCriteriaList();
	}

	private void setupMVP() {
		mainPresenter = new MainPresenter(this);
	}

	private void setupViews() {
		mainBinding.contentView.setLayoutManager(new LinearLayoutManager(this));
	}

	private void getCriteriaList() {
		mainPresenter.getData();
	}


	@Override
	public void onShowError() {

	}

	@Override
	public void hideProgressBar() {
		mainBinding.progressCircular.setVisibility(View.GONE);
	}

	@Override
	public void showProgressBar() {
		mainBinding.progressCircular.setVisibility(View.VISIBLE);
	}

	@Override
	public void onSuccess(List<MyData> myData) {
		MainAdapter adapter = new MainAdapter(myData, MainActivity.this);
		mainBinding.contentView.setAdapter(adapter);
	}


	public void showToast(String message) {
		Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onItemClick(MyData myData) {
		Intent intent = new Intent(this, DetailScreen.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable(ARG_DATA, Parcels.wrap(myData));
		intent.putExtras(bundle);
		startActivity(intent);
	}

}