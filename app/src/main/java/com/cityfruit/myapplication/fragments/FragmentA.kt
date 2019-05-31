package com.cityfruit.myapplication.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.cityfruit.myapplication.R
import com.cityfruit.myapplication.base_fg.BackMode
import com.cityfruit.myapplication.base_fg.annotations.Constrain
import com.cityfruit.myapplication.base_fg.annotations.ConstrainHome
import com.cityfruit.myapplication.base_fg.annotations.Container
import com.cityfruit.myapplication.base_fg.fragments.ConstrainFragment
import com.cityfruit.myapplication.base_fg.startFragmentByNewTask
import com.cityfruit.myapplication.getBundle
import com.cityfruit.myapplication.printBundle
import kotlinx.android.synthetic.main.fragment_a.*

@ConstrainHome
@Constrain(id = "FragmentA", backMode = BackMode.LASTING)
class FragmentA : ConstrainFragment() {

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
            startFragmentByNewTask(FragmentB::class.java, getBundle("frgA ==> frgB by new Task"), {
                finish()
            })
        }

        a_btn_finish.setOnClickListener {
            finish()
        }

        a_btn_next.setOnClickListener {
            startFragment(FragmentB::class.java, getBundle("frgA ==> frgB"))
        }
    }

    override fun initData() {
        val text = javaClass.simpleName
        txt.text = text
        bg.setBackgroundColor(activity?.getColor(R.color.c1) ?: Color.BLACK)
        Log.e("---- ", "$text.initData , backMod was LASTING")
    }
}