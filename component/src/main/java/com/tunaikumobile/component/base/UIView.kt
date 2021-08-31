package com.tunaikumobile.component.base

import android.view.ViewGroup
import androidx.annotation.IdRes


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
abstract class UIView(val container: ViewGroup) {

    @get:IdRes
    abstract val containerId: Int

    abstract fun showLoading()

    abstract fun showContent()
}