package com.cityfruit.myapplication.fragments

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cityfruit.myapplication.R
import com.zj.cf.BackMode
import com.zj.cf.annotations.Constrain
import com.zj.cf.fragments.ConstrainFragment
import com.zj.cf.managers.BaseFragmentManager
import com.cityfruit.myapplication.indecators.TabA
import com.cityfruit.myapplication.indecators.TabB
import com.cityfruit.myapplication.indecators.TabC
import kotlinx.android.synthetic.main.fragment_b.*
import kotlin.random.Random

@Constrain(id = "FragmentH", backMode = BackMode.ONLY_ONCE)
class FragmentH : ConstrainFragment() {

    override fun getView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onCreate() {
        super.onCreate()
        object : BaseFragmentManager(this, R.id.fragment_container, 0, ll, TabA(), TabB(), TabC()) {

        }
        val color = randomColor()
        ll?.setBackgroundColor(color)
    }

    private fun randomColor(rate: Int = 1): Int {
        val red = Random.nextInt(256) / rate
        val green = Random.nextInt(256) / rate
        val blue = Random.nextInt(256) / rate
        return Color.rgb(red, green, blue)
    }
}