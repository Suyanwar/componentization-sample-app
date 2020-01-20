package com.tunaikumobile.component.molecule.phonenumbercomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tunaikumobile.component.R
import com.tunaikumobile.component.base.UIView
import com.tunaikumobile.component.event.UserInteractionEvent


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
class PhoneNumberView(container: ViewGroup) : UIView<UserInteractionEvent>(container) {

    private val view : View = LayoutInflater.from(container.context).inflate(R.layout.component_phone_number, container, true)
        .findViewById(R.id.llcPhoneNumberView)

    override val containerId: Int = view.id

    override fun show() {
        view.visibility = View.VISIBLE
    }

    override fun hide() {
        view.visibility = View.GONE
    }

}