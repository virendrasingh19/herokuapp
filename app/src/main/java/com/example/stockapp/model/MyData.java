package com.example.stockapp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class MyData {

	@SerializedName("id")
	public int id;

	@SerializedName("name")
	public String name;

	@SerializedName("tag")
	public String tag;

	@SerializedName("color")
	public String color;

	@SerializedName("criteria")
	public List<Citeria> criteria;


}