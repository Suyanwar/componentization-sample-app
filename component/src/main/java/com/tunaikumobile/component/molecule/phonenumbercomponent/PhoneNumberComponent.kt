package com.tunaikumobile.component.molecule.phonenumbercomponent

import android.annotation.SuppressLint
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
@SuppressLint("CheckResult")
class PhoneNumberComponent(container: ViewGroup, bus: EventBusFactory) :
    UIComponent<Unit> {

    override fun getContainerId(): Int {
        return uiView.containerId
    }

    override fun getUserInteractionEvents(): Observable<Unit> {
        return Observable.empty()
    }

    private val uiView = initView(container)

    private fun initView(container: ViewGroup): PhoneNumberView {
        return PhoneNumberView(container)
    }

    init {
        bus.getSafeManagedObservable(ScreenStateEvent::class.java).subscribe {
            when (it) {
                ScreenStateEvent.Loading -> {
                    uiView.showLoading()
                }
                ScreenStateEvent.Loaded -> {
                    uiView.showContent()
                }
            }
        }
    }
}