package com.example.stockapp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Variable4 {
	@SerializedName("type")
	public String type;
	@SerializedName("study_type")
	public String studyType;
	@SerializedName("parameter_name")
	public String parameterName;
	@SerializedName("min_value")
	public Integer minValue;
	@SerializedName("max_value")
	public Integer maxValue;
	@SerializedName("default_value")
	public Integer defaultValue;

}
