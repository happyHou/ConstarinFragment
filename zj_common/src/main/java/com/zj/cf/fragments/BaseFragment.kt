@file:Suppress("MemberVisibilityCanBePrivate")

package com.zj.cf.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by zjj on 19.05.14.
 */
abstract class BaseFragment : Fragment() {

    open val id: String = UUID.randomUUID().toString()
    internal var managerId: String = ""
    var rootView: View? = null
    var removing = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = getView(inflater, container)
        val parent = rootView?.parent as ViewGroup?
        if (parent != null && parent.childCount > 0) {
            parent.removeView(rootView)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    override fun onSaveInstanceState(outState: Bundle) {

    }

    protected abstract fun getView(inflater: LayoutInflater, container: ViewGroup?): View

    protected abstract fun initView()

    protected abstract fun initData()

    protected fun <T : View> find(id: Int): T? {
        return rootView?.findViewById(id)
    }
}