package com.webuzz.intelligent.base.mvp;


import io.reactivex.Observable;

public interface BaseModel {
	<T> Observable<T> getData();
}
