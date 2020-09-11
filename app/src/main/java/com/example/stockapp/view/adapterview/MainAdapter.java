package com.example.stockapp.view.adapterview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.stockapp.R;
import com.example.stockapp.databinding.ItemCriteriaViewBinding;
import com.example.stockapp.model.MyData;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

	private List<MyData> myData = new ArrayList<>();
	private OnClickInterface onClickInterface;

	public MainAdapter(List<MyData> myData, OnClickInterface onClickInterface) {
		this.myData = myData;
		this.onClickInterface = onClickInterface;
	}

	@NonNull
	@Override
	public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		ItemCriteriaViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
				R.layout.item_criteria_view, parent, false);
		return new MainViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
		ItemCriteriaViewBinding headerBinding = holder.itemCriteriaViewBinding;
		holder.bind(myData.get(position));
		headerBinding.getRoot().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickInterface.onItemClick(myData.get(position));
			}
		});
		headerBinding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return myData.size();
	}
}
