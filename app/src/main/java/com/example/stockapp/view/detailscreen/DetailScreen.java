package com.example.stockapp.view.detailscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.stockapp.R;
import com.example.stockapp.databinding.ActivityDetailScreenBinding;
import com.example.stockapp.model.MyData;
import com.example.stockapp.utils.Constants;

import org.parceler.Parcels;

import static com.example.stockapp.MainActivity.ARG_DATA;


public class DetailScreen extends AppCompatActivity {

	private MyData myData;
	private ActivityDetailScreenBinding detailScreenBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		detailScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_screen);
		extractData();
		setupView();
		setData();
	}

	private void extractData() {
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			myData = Parcels.unwrap(bundle.getParcelable(ARG_DATA));
		}
	}

	private void setupView() {
		detailScreenBinding.contentView.setLayoutManager(new LinearLayoutManager(this));
	}

	private void setData() {
		detailScreenBinding.headerText.setText(myData.name);
		if (Constants.Colors.GREEN.equalsIgnoreCase(myData.color)) {
			detailScreenBinding.subHeaderText.setTextColor(detailScreenBinding.getRoot()
					.getResources().getColor(R.color.green_light));
		} else {
			detailScreenBinding.subHeaderText.setTextColor(detailScreenBinding.getRoot()
					.getResources().getColor(R.color.red));
		}
		detailScreenBinding.subHeaderText.setText(myData.tag);
		setAdapter();
	}

	private void setAdapter() {
		DetailScreenAdapter adapter = new DetailScreenAdapter(myData.criteria);
		detailScreenBinding.contentView.setAdapter(adapter);
	}


}