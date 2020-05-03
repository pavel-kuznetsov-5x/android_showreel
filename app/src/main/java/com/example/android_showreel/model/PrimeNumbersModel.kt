package com.example.android_showreel.model

import com.cucumber007.reusables.utils.logging.LogUtil
import io.reactivex.Emitter
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable

enum class Source {
    RX
}

class PrimeNumbersModel {

    private var source: Source = Source.RX

    fun changeSource(_source: Source) {
        source = _source
    }

    fun primeNumbersPublisher() {
        when(source) {
            Source.RX -> {
                Flowable
                    .generate(
                        Callable<Int> { 0 },
                        BiFunction<Int, Emitter<Int>, Int> { state, emitter ->
                            LogUtil.logDebug("Generating", Thread.currentThread().name, state)
                            emitter.onNext(state);
                            state + 1;
                        })
                    .flatMap {
                        Flowable.just(it)
                            .subscribeOn(Schedulers.computation())
                            .filter {
                                val time = (Math.random() * 1000).toLong()
                                LogUtil.logDebug("Starting", Thread.currentThread().name, it, time)
                                Thread.sleep(time)
                                PrimeNumbersUtil.isPrime(it)
                            }
                    }
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }

}