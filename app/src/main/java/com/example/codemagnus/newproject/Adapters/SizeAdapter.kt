package com.example.codemagnus.newproject.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codemagnus.newproject.Activities.MainActivity
import com.example.codemagnus.newproject.Fragments.CheckOutFragment
import com.example.codemagnus.newproject.Fragments.SizeSelectionFragment
import com.example.codemagnus.newproject.Models.Product
import com.example.codemagnus.newproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.size_content.view.*

/**
 * Created by codemagnus on 3/20/18.
 */
class SizeAdapter(val mContext:Context):RecyclerView.Adapter<SizeAdapter.ViewHolder>() {

    var mActivity: MainActivity? = null
    var itemList:MutableList<Product> = mutableListOf()

    init {
        mActivity = mContext as MainActivity?
        itemList = mActivity!!.staticData
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.size_content,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBindItem(position,mContext)
    }

    override fun getItemCount(): Int {
        return mActivity?.staticData!!.size
    }

    open inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {


        fun onBindItem(position: Int, mContext: Context){

            val item = itemList[position]
            Picasso.with(mContext).load(item.imgUrl).resize(150,150   ).centerCrop().into(itemView.iv_item_content2)

            itemView.cv_item2.setOnClickListener{
                mActivity!!.fm!!.beginTransaction().apply {
                    replace(R.id.main_frame, CheckOutFragment(), CheckOutFragment.TAG)
                    addToBackStack(CheckOutFragment.TAG)
                }.commit()
            }




        }

    }
}