package com.webuzz.intelligent.module.device.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @name WeBuzz
 * @class name：com.webuzz.intelligent.module.device.bean
 * @class describe
 * @anthor wfc QQ: 335441537
 * @time 2017/6/20 00:12
 * @change
 * @chang time
 * @class describe
 */
public class DeviceInfo implements Serializable {

	@SerializedName("num")
	public String num;

	@SerializedName("state")
	public String state;

	@SerializedName("beterry")
	public String beterry;

	public DeviceInfo(String num, String state, String status) {
		this.num = num;
		this.state = state;
		this.beterry = status;
	}
}
