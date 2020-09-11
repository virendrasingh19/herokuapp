package com.example.stockapp.view.detailscreen;

import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.R;
import com.example.stockapp.databinding.ItemDetailViewBinding;
import com.example.stockapp.model.Citeria;
import com.example.stockapp.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailScreenViewHolder extends RecyclerView.ViewHolder {

	public ItemDetailViewBinding itemDetailViewBinding;

	public DetailScreenViewHolder(ItemDetailViewBinding itemDetailViewBinding) {
		super(itemDetailViewBinding.getRoot());
		this.itemDetailViewBinding = itemDetailViewBinding;
	}

	public void bind(Citeria citeria, int position, int citeriaSize) {
		if (Constants.TextType.PLAIN_TEXT.equalsIgnoreCase(citeria.type)) {
			if (position + 1 != citeriaSize) {
				itemDetailViewBinding.content.setText(String.format("%s \n\n%s", citeria.text, itemDetailViewBinding.getRoot().getResources().getString(R.string.and)));
			} else {
				itemDetailViewBinding.content.setText(citeria.text);
			}
		} else {
			List<String> containObj = new ArrayList<>();
			List<String> containValue = new ArrayList<>();
			if (Constants.TextType.VARIABLE.equalsIgnoreCase(citeria.type)) {
				HashMap<String, Object> variableMap = new HashMap<>();
				if (citeria.text.contains(Constants.Variable.V1)) {
					variableMap.put(Constants.Variable.V1, citeria.variable.variable1);
				}
				if (citeria.text.contains(Constants.Variable.V2)) {
					variableMap.put(Constants.Variable.V2, citeria.variable.variable2);
				}
				if (citeria.text.contains(Constants.Variable.V3)) {
					variableMap.put(Constants.Variable.V3, citeria.variable.variable3);
				}
				if (citeria.text.contains(Constants.Variable.V4)) {
					variableMap.put(Constants.Variable.V4, citeria.variable.variable4);
				}
				if (variableMap.get(Constants.Variable.V1) != null) {
					containObj.add(Constants.Variable.V1);
					if (citeria.variable.variable1.type.equalsIgnoreCase(Constants.TextType.VALUE)) {
						containValue.add(citeria.variable.variable1.values.get(0).toString());
					} else if (citeria.variable.variable1.type.equalsIgnoreCase(Constants.TextType.INDICATOR)) {
						containValue.add(citeria.variable.variable1.defaultValue.toString());
					}
				}
				if (variableMap.get(Constants.Variable.V2) != null) {
					containObj.add(Constants.Variable.V2);
					if (citeria.variable.variable2.type.equalsIgnoreCase(Constants.TextType.VALUE)) {
						containValue.add(citeria.variable.variable2.values.get(0).toString());
					}
				}
				if (variableMap.get(Constants.Variable.V3) != null) {
					containObj.add(Constants.Variable.V3);
					if (citeria.variable.variable3.type.equalsIgnoreCase(Constants.TextType.VALUE)) {
						containValue.add(citeria.variable.variable3.values.get(0).toString());
					}
				}
				if (variableMap.get(Constants.Variable.V4) != null) {
					containObj.add(Constants.Variable.V4);
					if (citeria.variable.variable4.type.equalsIgnoreCase(Constants.TextType.INDICATOR)) {
						containValue.add(citeria.variable.variable4.defaultValue.toString());
					}
				}

				String newText = "";
				for (int i = 0; i < containObj.size(); i++) {
					newText = citeria.text.replace(containObj.get(i), containValue.get(i));
					citeria.text = newText;
				}
				if (position + 1 != citeriaSize) {
					itemDetailViewBinding.content.setText(String.format("%s \n\n%s", newText, itemDetailViewBinding.getRoot().getResources().getString(R.string.and)));
				} else {
					itemDetailViewBinding.content.setText(newText);
				}

			}
		}
	}


}
