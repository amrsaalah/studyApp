package com.bignerdranch.android.studyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class RxActivity extends AppCompatActivity {

    private static final String TAG = "RxActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        Observable<String> values = Observable.just("one", "two", "three");
        Disposable subscription = values.subscribe(
                v -> Log.e(TAG, "onCreate: " + v),
                e -> Log.e(TAG, "onCreate: " + e),
                () -> Log.e(TAG, "onCreate: ")
        );


        Observable<Integer> observable = Observable.range(0, 10);
        Disposable oddNumbers = observable
                .filter(v -> v % 2 == 0)
                .subscribe(
                        v -> Log.e(TAG, "onCreate: " + v),
                        e -> Log.e(TAG, "onCreate: "),
                        () -> Log.e(TAG, "onCreate:  completed")
                );


        Observable<Integer> ob = Observable.range(0, 5);

        ob.scan((integer, integer2) -> integer + integer2)
                .subscribe(integer -> Log.e(TAG, "onCreate: " + integer), throwable -> Log.e(TAG, "onCreate: "), () -> Log.e(TAG, "onCreate: "));


        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
                                                                @Override

                                                                public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                                                                    //Use onNext to emit each item in the stream//
                                                                    e.onNext(1);
                                                                    e.onNext(2);
                                                                    e.onNext(3);
                                                                    e.onNext(4);

                                                                    //Once the Observable has emitted all items in the sequence, call onComplete//
                                                                    e.onComplete();
                                                                }
                                                            }
        );


        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer value) {
                Log.e(TAG, "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: All Done!");
            }
        };

        observable1.subscribe(observer);

    }
}
