package com.cityfruit.myapplication.base_fg.unitive

import android.support.v4.app.FragmentTransaction
import com.cityfruit.myapplication.base_fg.fragments.BaseFragment

/**
 * Created by zjj on 19.05.14.
 */
interface FragmentOperator<F : BaseFragment> {

    fun beginTransaction(transaction: FragmentTransaction, curShowId: String, mFragments: MutableMap<String, F>)

    fun syncSelectState(selectId: String)

    fun whenShowSameFragment(shownId: String)

    fun whenShowNotSameFragment(shownId: String): Boolean
}