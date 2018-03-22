package com.example.codemagnus.newproject.Fragments

import android.support.v4.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codemagnus.newproject.Activities.MainActivity
import com.example.codemagnus.newproject.Adapters.SizeAdapter
import com.example.codemagnus.newproject.R
import com.example.codemagnus.newproject.R.id.rv_sizeselect
import kotlinx.android.synthetic.main.fragment_size_selection.*

/**
 * Created by codemagnus on 3/21/18.
 */
class SizeSelectionFragment: Fragment() {

    private var mActivity:MainActivity? = null
    private var adapter:SizeAdapter? = null

    companion object {
        val TAG: String = SizeSelectionFragment::class.java.simpleName
        var instance: SizeSelectionFragment? = SizeSelectionFragment()

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        instance = this
        return inflater?.inflate(R.layout.fragment_size_selection, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = context as MainActivity?
        mActivity?.setToolbar(false, "Choose desired size")

        adapter = SizeAdapter(context)
        rv_sizeselect.layoutManager = GridLayoutManager(context,2)
        rv_sizeselect.adapter = adapter

    }

    override fun onDetach() {
        super.onDetach()

        if (this.isRemoving) {
            val fm = fragmentManager
            fm.beginTransaction().remove(SizeSelectionFragment()).commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null

    }
}