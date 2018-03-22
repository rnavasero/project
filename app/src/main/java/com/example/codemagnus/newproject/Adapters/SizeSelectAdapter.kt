package com.example.codemagnus.newproject.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codemagnus.newproject.Activities.MainActivity
import com.example.codemagnus.newproject.Fragments.CheckOutFragment
import com.example.codemagnus.newproject.Models.Product
import com.example.codemagnus.newproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_size.view.*
import kotlinx.android.synthetic.main.size_content.view.*

/**
 * Created by codemagnus on 3/22/18.
 */
class SizeSelectAdapter(val mContext:Context):RecyclerView.Adapter<SizeSelectAdapter.ViewHolder>() {

    var mActivity: MainActivity? = null
    var itemList:MutableList<Product> = mutableListOf()

    init {
        mActivity = mContext as MainActivity?
        itemList = mActivity!!.sData
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBindItemHolder(position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.layout_size,parent,false)
        return ViewHolder(v)
    }

    open inner class ViewHolder(v:View):RecyclerView.ViewHolder(v) {

        fun onBindItemHolder(position: Int){

            val item = itemList[position]

            if(item.name == "Small")
            {
                Picasso.with(mContext).load(item.imgUrl).resize(150,150   ).centerCrop().into(itemView.im_size)
                itemView.tv_size_sample.text = item.name
            }
            if(item.name == "Medium")
            {
                Picasso.with(mContext).load(item.imgUrl).resize(150,150   ).centerCrop().into(itemView.im_size)
                itemView.tv_size_sample.text = item.name
            }
            if(item.name == "Large")
            {
                Picasso.with(mContext).load(item.imgUrl).resize(150,150   ).centerCrop().into(itemView.im_size)
                itemView.tv_size_sample.text = item.name
            }

            itemView.ll_itemSize.setOnClickListener{
                mActivity!!.fm!!.beginTransaction().apply {
                    replace(R.id.main_frame, CheckOutFragment(), CheckOutFragment.TAG)
                    addToBackStack(CheckOutFragment.TAG)
                }.commit()
            }

        }

    }
}