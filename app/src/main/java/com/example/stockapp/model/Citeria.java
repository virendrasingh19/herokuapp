package com.example.stockapp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Citeria {

	@SerializedName("type")
	public String type;

	@SerializedName("text")
	public String text;

	@SerializedName("variable")
	public Variable variable;

}
