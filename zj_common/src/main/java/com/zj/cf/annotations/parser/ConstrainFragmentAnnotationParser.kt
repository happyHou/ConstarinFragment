package com.zj.cf.annotations.parser

import android.os.Bundle
import com.zj.cf.BackMode
import com.zj.cf.LaunchMode.FOLLOW
import com.zj.cf.annotations.Constrain
import com.zj.cf.annotations.ConstrainHome
import com.zj.cf.annotations.LaunchMode
import com.zj.cf.fragments.ConstrainFragment
import com.zj.cf.managers.ConstrainFragmentManager
import com.zj.cf.generateId
import com.zj.cf.unitive.ProxyManager

internal object ConstrainFragmentAnnotationParser {

    @Throws(NullPointerException::class)
    fun <T : ConstrainFragment> parseAnnotations(fragmentCls: Class<T>, bundle: Bundle?, fragmentManager: ConstrainFragmentManager?): ProxyManager<T> {
        val launchModeParse = AnnotationParser.parseCls<LaunchMode>(fragmentCls)
        val constrainHomeParse = AnnotationParser.parseCls<ConstrainHome>(fragmentCls)
        val launchMode = launchModeParse?.mode ?: FOLLOW
        val isHome = constrainHomeParse != null
        val constrainParser = AnnotationParser.parseCls<Constrain>(fragmentCls)
        val backMode = constrainParser?.backMode ?: BackMode.ONLY_ONCE
        val fid = generateId(constrainParser?.id ?: throw NullPointerException("the fragment id was not found,did you forgot annotation : Constrain( id = \"XXX\") in your ${fragmentCls.simpleName}.class?"), fragmentManager ?: throw NullPointerException("bad request ! you still haven’t a manager yet!"))
        return ProxyManager(fragmentCls, fid, backMode, launchMode, isHome, bundle)
    }
}

