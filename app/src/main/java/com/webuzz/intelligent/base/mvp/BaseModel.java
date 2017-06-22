package com.webuzz.intelligent.base.mvp;


import rx.Observable;


public interface BaseModel {
	<T> Observable<T> getData();
}
