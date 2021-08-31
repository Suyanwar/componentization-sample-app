package com.tunaikumobile.component.molecule.instantloancomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tunaikumobile.component.R
import com.tunaikumobile.component.base.UIView

class InstantLoanView(container: ViewGroup): UIView(container) {

    private val inflater: View = LayoutInflater.from(container.context).inflate(R.layout.component_instant_loan, container, true)
    private val instantLoanShimmerLayout : View = inflater.findViewById(R.id.sflInstantLoanView)
    private val instantLoanViewLayout : View = inflater.findViewById(R.id.clInstantLoanView)

    override val containerId: Int = inflater.id

    override fun showLoading() {
        instantLoanViewLayout.visibility = View.GONE
        instantLoanShimmerLayout.visibility = View.VISIBLE
    }

    override fun showContent() {
        instantLoanShimmerLayout.visibility = View.GONE
        instantLoanViewLayout.visibility = View.VISIBLE
    }
}