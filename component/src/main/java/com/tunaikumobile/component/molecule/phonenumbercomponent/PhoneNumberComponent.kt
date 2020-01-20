package com.tunaikumobile.component.molecule.phonenumbercomponent

import android.view.ViewGroup
import com.tunaikumobile.component.base.EventBusFactory
import com.tunaikumobile.component.base.UIComponent
import com.tunaikumobile.component.event.ScreenStateEvent
import io.reactivex.Observable


/**
 *
 * Created by Suyanwar on 2020-01-16.
 * Android Engineer
 *
 **/
open class PhoneNumberComponent(container: ViewGroup, bus: EventBusFactory) :
    UIComponent<Unit> {

    override fun getContainerId(): Int {
        return uiView.containerId
    }

    override fun getUserInteractionEvents(): Observable<Unit> {
        return Observable.empty()
    }

    private val uiView = initView(container)

    open fun initView(container: ViewGroup): PhoneNumberView {
        return PhoneNumberView(container)
    }

    init {
        bus.getSafeManagedObservable(ScreenStateEvent::class.java).subscribe {
            when(it) {
                ScreenStateEvent.Loading -> {
                    uiView.hide()
                }
                ScreenStateEvent.Loaded -> {
                    uiView.show()
                }
            }
        }
    }
}