package com.example.codemagnus.newproject.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codemagnus.newproject.Activities.MainActivity
import com.example.codemagnus.newproject.Fragments.CheckOutFragment
import com.example.codemagnus.newproject.Fragments.SizeSelectionFragment.Companion.category
import com.example.codemagnus.newproject.Fragments.SizeSelectionFragment.Companion.i_image
import com.example.codemagnus.newproject.Models.Product
import com.example.codemagnus.newproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_size.view.*
import kotlinx.android.synthetic.main.size_content.view.*

/**
 * Created by codemagnus on 3/22/18.
 */
class SizeSelectAdapter(private val mContext:Context, var _category:String?,var _image:Int?,var _name:String?, private var itemID:String?):RecyclerView.Adapter<SizeSelectAdapter.ViewHolder>() {

    private val TAG2 = "#####################"

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

        private val _c = _category
        private val _i = _image
        private val _n = _name
        private val _i_ID = itemID


        fun onBindItemHolder(position: Int){

            val item = itemList[position]
            itemView.tv_size_sample.text = item.size

            itemView.ll_itemSize.setOnClickListener {

                    when (item.size){

                        "Small"->
                        {
                            item.id = "${itemID.toString()}1"
                            item.category = _c!!
                            item.name = _n!!
                            item.qty = 1
                            item.flavor = item.size
                            item.imgUrl = _i!!
                            item.price = 10.00
                        }

                        "Medium"->
                        {
                            item.id = "${itemID.toString()}2"
                            item.category = _c!!
                            item.name = _n!!
                            item.qty = 1
                            item.flavor = item.size
                            item.imgUrl = _i!!
                            item.price = 15.00
                        }

                        "Large"->
                        {
                            item.id = "${itemID.toString()}3"
                            item.category = _c!!
                            item.name = _n!!
                            item.qty = 1
                            item.flavor = item.size
                            item.imgUrl = _i!!
                            item.price = 20.00
                        }

                    }
                mActivity!!.cart.add(Product(item.id, item.name, item.description, item.imgUrl,item.category,item.flavor,item.size,item.price,item.qty))
                mActivity!!.setCartCount(mActivity!!.productCount + 1)
                mActivity!!.newFragment(CheckOutFragment(),CheckOutFragment.TAG)
            }

        }

    }
}