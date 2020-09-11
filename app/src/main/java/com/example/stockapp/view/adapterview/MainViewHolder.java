package com.example.stockapp.view.adapterview;

import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.R;
import com.example.stockapp.databinding.ItemCriteriaViewBinding;
import com.example.stockapp.model.MyData;
import com.example.stockapp.utils.Constants;


public class MainViewHolder extends RecyclerView.ViewHolder {

	public ItemCriteriaViewBinding itemCriteriaViewBinding;

	public MainViewHolder(ItemCriteriaViewBinding itemCriteriaViewBinding) {
		super(itemCriteriaViewBinding.getRoot());
		this.itemCriteriaViewBinding = itemCriteriaViewBinding;
	}

	public void bind(MyData myData) {
		itemCriteriaViewBinding.headerText.setText(myData.name);
		if (Constants.Colors.GREEN.equalsIgnoreCase(myData.color)) {
			itemCriteriaViewBinding.subHeaderText.setTextColor(itemCriteriaViewBinding.getRoot()
					.getResources().getColor(R.color.green_light));
		} else {
			itemCriteriaViewBinding.subHeaderText.setTextColor(itemCriteriaViewBinding.getRoot()
					.getResources().getColor(R.color.red));
		}
		itemCriteriaViewBinding.subHeaderText.setText(myData.tag);
	}

}
