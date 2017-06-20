package com.webuzz.intelligent.module.mine.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ScoreCategory implements Serializable {

	@SerializedName("score")
	public String score;

	@SerializedName("category")
	public String category;


	public ScoreCategory(String score, String category) {
		this.score = score;
		this.category = category;
	}
}
