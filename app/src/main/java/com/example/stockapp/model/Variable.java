package com.example.stockapp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Variable {

	@SerializedName("$1")
	public Variable1 variable1;

	@SerializedName("$2")
	public Variable2 variable2;

	@SerializedName("$3")
	public Variable3 variable3;

	@SerializedName("$4")
	public Variable4 variable4;

}
