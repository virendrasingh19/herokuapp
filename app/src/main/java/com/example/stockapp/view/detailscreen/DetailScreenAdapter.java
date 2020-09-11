package com.example.stockapp.view.detailscreen;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.R;
import com.example.stockapp.databinding.ItemDetailViewBinding;
import com.example.stockapp.model.Citeria;

import java.util.ArrayList;
import java.util.List;

public class DetailScreenAdapter extends RecyclerView.Adapter<DetailScreenViewHolder> {

	private List<Citeria> citerias;

	public DetailScreenAdapter(List<Citeria> myData) {
		this.citerias = myData;
	}

	@NonNull
	@Override
	public DetailScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		ItemDetailViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
				R.layout.item_detail_view, parent, false);
		return new DetailScreenViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull DetailScreenViewHolder holder, final int position) {
		ItemDetailViewBinding headerBinding = holder.itemDetailViewBinding;
		holder.bind(citerias.get(position), position, citerias.size());
		headerBinding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return citerias.size();
	}
}
