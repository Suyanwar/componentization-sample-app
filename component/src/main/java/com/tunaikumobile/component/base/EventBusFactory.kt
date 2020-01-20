package com.tunaikumobile.component.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
class EventBusFactory constructor(val owner: LifecycleOwner) {
    companion object {
        private val buses = mutableMapOf<LifecycleOwner, EventBusFactory>()

        @JvmStatic
        fun get(lifecycleOwner: LifecycleOwner): EventBusFactory {
            return with(lifecycleOwner) {
                var bus = buses[this]
                if (bus == null) {
                    bus = EventBusFactory(this)
                    buses[this] = bus
                    // LifecycleOwner
                    lifecycleOwner.lifecycle.addObserver(bus.observer)
                }
                bus
            }
        }
    }

    val map = HashMap<Class<*>, Subject<*>>()

    internal val observer = object : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            map.forEach { entry -> entry.value.onComplete() }
            buses.remove(owner)
        }
    }

    private fun <T> create(clazz: Class<T>): Subject<T> {
        val subject = PublishSubject.create<T>().toSerialized()
        map[clazz] = subject
        return subject
    }

    fun <T : ComponentEvent> emit(clazz: Class<T>, event: T) {
        val subject = if (map[clazz] != null) map[clazz] else create(clazz)
        (subject as Subject<T>).onNext(event)
    }

    fun <T : ComponentEvent> getSafeManagedObservable(clazz: Class<T>): Observable<T> {
        return if (map[clazz] != null) map[clazz] as Observable<T> else create(clazz)
    }
}