package com.pj.lb.rxjavapractice;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @className: RxjavaPractice
 * @classDescription: rxjava practice
 * @author: leibing
 * @createTime:2017/8/16
 */
public class RxjavaPractice {
    // tag
    private final static String TAG = "RxjavaPractice";

    /**
     * simple rxjava do
     * @author leibing
     * @createTime 2017/8/16
     * @lastModify 2017/8/16
     * @param
     * @return
     */
    public static void simpleRxDo(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "#simpleRxDo#subscribe 1");
                e.onNext(1);
                Log.e(TAG, "#simpleRxDo#subscribe 2");
                e.onNext(2);
                Log.e(TAG, "#simpleRxDo#subscribe 3");
                e.onNext(3);
                Log.e(TAG, "#simpleRxDo#subscribe 4");
                e.onNext(4);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "#simpleRxDo#onSubscribe d = " + d);
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG, "#simpleRxDo#onSubscribe onNext = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "#simpleRxDo#onSubscribe onError = " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "#simpleRxDo#onSubscribe onComplete");
            }
        });
    }

    /**
     * rx map do
     * @author leibing
     * @createTime 2017/8/16
     * @lastModify 2017/8/16
     * @param
     * @return
     */
    public static void rxMapDo(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.e(TAG, "#rxMapDo#subscribe 9527");
                e.onNext("9527");
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new Function<String, Integer>() {
            @Override
            public Integer apply(@NonNull String s) throws Exception {
                Log.e(TAG, "#rxMapDo#apply s = " + s);
                return Integer.parseInt(s);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "#rxMapDo#onSubscribe d = " + d);
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG, "#rxMapDo#onNext integer = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "#rxMapDo#onNext onError = " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "#rxMapDo#onNext onComplete");
            }
        });
    }
}
