package com.tunaikumobile.componentizationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.tunaikumobile.component.base.EventBusFactory
import com.tunaikumobile.component.event.ScreenStateEvent
import com.tunaikumobile.component.molecule.phonenumbercomponent.PhoneNumberComponent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit


/**
 *
 * Created by Suyanwar on 2020-01-20.
 * Android Engineer
 *
 **/

class TestActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var lifecycleRegistry : LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)

        setContentView(R.layout.activity_test)
        PhoneNumberComponent(findViewById(R.id.firstView), EventBusFactory.get(this))
        PhoneNumberComponent(findViewById(R.id.secondView), EventBusFactory.get(this))
        PhoneNumberComponent(findViewById(R.id.thirdView), EventBusFactory.get(this))
        Observable.just(Any())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                EventBusFactory.get(this)
                    .emit(ScreenStateEvent::class.java, ScreenStateEvent.Loading)
            }
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                EventBusFactory.get(this)
                    .emit(ScreenStateEvent::class.java, ScreenStateEvent.Loaded)
            }
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                EventBusFactory.get(this)
                    .emit(ScreenStateEvent::class.java, ScreenStateEvent.Loading)
            }
            .subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }
}