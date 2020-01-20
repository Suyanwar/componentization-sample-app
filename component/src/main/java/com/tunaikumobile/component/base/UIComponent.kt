package com.tunaikumobile.component.base

import io.reactivex.Observable


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
interface UIComponent<T> {
    fun getContainerId(): Int
    fun getUserInteractionEvents(): Observable<T>
}