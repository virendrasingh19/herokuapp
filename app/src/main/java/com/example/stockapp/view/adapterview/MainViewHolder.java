package com.example.stockapp.view.adapterview;

import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.databinding.ItemCriteriaViewBinding;
import com.example.stockapp.model.MyData;


public class MainViewHolder extends RecyclerView.ViewHolder {

	public ItemCriteriaViewBinding itemCriteriaViewBinding;

	public MainViewHolder(ItemCriteriaViewBinding itemCriteriaViewBinding) {
		super(itemCriteriaViewBinding.getRoot());
		this.itemCriteriaViewBinding = itemCriteriaViewBinding;
	}

	public void bind(MyData myData) {

	}

}
