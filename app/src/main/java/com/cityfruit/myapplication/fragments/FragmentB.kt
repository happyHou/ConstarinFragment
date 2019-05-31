package com.cityfruit.myapplication.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.cityfruit.myapplication.R
import com.cityfruit.myapplication.base_fg.BackMode
import com.cityfruit.myapplication.base_fg.LaunchMode.FOLLOW
import com.cityfruit.myapplication.base_fg.annotations.Constrain
import com.cityfruit.myapplication.base_fg.annotations.Container
import com.cityfruit.myapplication.base_fg.annotations.LaunchMode
import com.cityfruit.myapplication.base_fg.fragments.ConstrainFragment
import com.cityfruit.myapplication.base_fg.startFragmentByNewTask
import com.cityfruit.myapplication.getBundle
import com.cityfruit.myapplication.printBundle
import kotlinx.android.synthetic.main.fragment_a.*

@LaunchMode(mode = FOLLOW)
@Constrain(id = "FragmentB", backMode = BackMode.ONLY_ONCE)
class FragmentB : ConstrainFragment() {

    @Container
    var frgContainer: FrameLayout? = null

    override val layoutId: Int
        get() = R.layout.fragment_a


    override fun onPostValue(bundle: Bundle?) {
        printBundle(bundle, false)
    }

    override fun initView() {
        frgContainer = fragment_container
        a_btn_new_task.setOnClickListener {
            startFragmentByNewTask(FragmentC::class.java, getBundle("frgA ==> frgC by new Task"), {
                finish()
            })
        }

        a_btn_finish.setOnClickListener {
            finish()
        }

        a_btn_next.setOnClickListener {
            startFragment(FragmentC::class.java, getBundle("frgB ==> frgC"))
        }
    }

    override fun initData() {
        val text = javaClass.simpleName
        txt.text = text
        bg.setBackgroundColor(activity?.getColor(R.color.c2) ?: Color.BLACK)
        Log.e("---- ", "$text.initData , backMod was LASTING")
    }
}