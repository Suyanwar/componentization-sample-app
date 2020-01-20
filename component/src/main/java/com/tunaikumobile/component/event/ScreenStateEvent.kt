package com.tunaikumobile.component.event

import com.tunaikumobile.component.base.ComponentEvent


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
sealed class ScreenStateEvent : ComponentEvent() {
    object Loading : ScreenStateEvent()
    object Loaded : ScreenStateEvent()
}