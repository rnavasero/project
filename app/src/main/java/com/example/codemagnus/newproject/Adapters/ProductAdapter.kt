package com.example.codemagnus.newproject.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codemagnus.newproject.Activities.MainActivity
import com.example.codemagnus.newproject.Models.Product
import com.example.codemagnus.newproject.R
import com.example.codemagnus.newproject.Fragments.SizeSelectionFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.category_content.view.*

/**
 * Created by codemagnus on 3/20/18.
 */
class ProductAdapter(val mContext:Context?, itemList:MutableList<Product>?):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    val items = itemList

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindHolderbyPosition(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.category_content, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

//    fun updateCart(product: Product){
//        for (i in 0 until items!!.size){
//            if (items?.get(i)?.id == product.id){
//                items?.get(i)?.qty = product.qty
//                notifyItemChanged(i)
//            }
//        }
//    }

    fun deleteCard(product: Product){
        for (i in 0 until items!!.size){
            if (items?.get(i)?.id == product.id){
                items?.get(i)?.qty = 0
                notifyItemChanged(i)
            }
        }
    }


    open inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val mActivity = mContext as MainActivity?

        fun bindHolderbyPosition(position: Int){
            val item = items!![position]
            itemView.tv_item_name.text = item.name
            Picasso.with(mContext).load(item.imgUrl).resize(260,260).centerCrop().into(itemView.iv_item_content)

            itemView.iv_item_content.setOnClickListener {

                if (item.category == "Flavored Fries") {
                    SizeSelectionFragment.category = item.category
                    mActivity?.newFragment(SizeSelectionFragment(), SizeSelectionFragment.TAG)


                }

                if (item.category == "Fancy Fries"){
                    SizeSelectionFragment.category = item.category
                    mActivity?.newFragment(SizeSelectionFragment(), SizeSelectionFragment.TAG)

                }

                if (item.category == "Beverages"){
                    SizeSelectionFragment.category = item.category
                    mActivity?.newFragment(SizeSelectionFragment(), SizeSelectionFragment.TAG)

                }
            }

        }

    }
}