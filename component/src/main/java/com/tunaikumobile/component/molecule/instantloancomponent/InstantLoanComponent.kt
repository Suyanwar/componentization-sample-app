package com.tunaikumobile.component.molecule.instantloancomponent

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.tunaikumobile.component.base.EventBusFactory
import com.tunaikumobile.component.base.UIComponent
import com.tunaikumobile.component.event.ScreenStateEvent
import io.reactivex.Observable

@SuppressLint("CheckResult")
class InstantLoanComponent(container: ViewGroup, bus: EventBusFactory) : UIComponent<Unit> {

    private val uiView = initView(container)

    override fun getContainerId(): Int {
        return uiView.containerId
    }

    override fun getUserInteractionEvents(): Observable<Unit> {
        return Observable.empty()
    }

    private fun initView(container: ViewGroup): InstantLoanView {
        return InstantLoanView(container)
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