package com.tunaikumobile.component.molecule.phonenumbercomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tunaikumobile.component.R
import com.tunaikumobile.component.base.UIView


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
class PhoneNumberView(container: ViewGroup) : UIView(container) {

    private val inflater: View = LayoutInflater.from(container.context).inflate(R.layout.component_phone_number, container, true)

    private val phoneShimmerLayout : View = inflater.findViewById(R.id.sflPhoneNumberView)
    private val phoneViewLayout : View = inflater.findViewById(R.id.llcPhoneNumberView)

    override val containerId: Int = inflater.id

    override fun showLoading() {
        phoneViewLayout.visibility = View.GONE
        phoneShimmerLayout.visibility = View.VISIBLE
    }

    override fun showContent() {
        phoneShimmerLayout.visibility = View.GONE
        phoneViewLayout.visibility = View.VISIBLE
    }
}