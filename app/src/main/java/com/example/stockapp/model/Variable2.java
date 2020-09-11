package com.example.stockapp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Variable2 {

	@SerializedName("type")
	public String type;
	@SerializedName("values")
	public List<Integer> values = null;

}
