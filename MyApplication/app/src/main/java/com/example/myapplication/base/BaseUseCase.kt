package com.example.myapplication.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCaseSingle<T, S>(

    val disposable: CompositeDisposable,
    val offScheduler: Scheduler = Schedulers.io(),
    val mainScheduler: Scheduler = AndroidSchedulers.mainThread()) {

    abstract fun buildUseCaseSingle(params: T? = null): Single<S>

    fun executeUseCase(params: T?, onSuccess: Consumer<S>, onError: Consumer<in Throwable>) =
        disposable.add(buildUseCaseSingle(params)
        .subscribeOn(offScheduler)
            .observeOn(mainScheduler)
            .subscribe(onSuccess, onError))
}