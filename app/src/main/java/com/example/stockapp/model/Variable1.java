package com.example.stockapp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Variable1 {


	@SerializedName("type")
	public String type;

	@SerializedName("values")
	public List<Integer> values;

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
