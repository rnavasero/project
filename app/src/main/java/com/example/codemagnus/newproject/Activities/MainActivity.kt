package com.example.codemagnus.newproject.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.Toolbar
import android.text.TextUtils.replace
import android.view.Gravity
import android.view.View
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import android.widget.Toast
import com.example.codemagnus.newproject.Adapters.CheckOutRecyclerAdapter
import com.example.codemagnus.newproject.Adapters.ProductAdapter
import com.example.codemagnus.newproject.Fragments.CheckOutFragment
import com.example.codemagnus.newproject.Fragments.SizeSelectionFragment
import com.example.codemagnus.newproject.Models.Product
import com.example.codemagnus.newproject.Models.ProductDataBase
import com.example.codemagnus.newproject.Models.StaticData
import com.example.codemagnus.newproject.Models.StaticSizeData
import com.example.codemagnus.newproject.R
import com.example.codemagnus.newproject.Session.Session
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_cart.view.*
import kotlinx.android.synthetic.main.menu.*
import kotlinx.coroutines.experimental.android.UI

class MainActivity : AppCompatActivity() {

    var mAdapter = CheckOutRecyclerAdapter(this)
    var menu: View? = null
    var cartmenu: View? = null
    var cart: MutableList<Product> = ArrayList()
    private var cartView: View? = null
    var fm: FragmentManager? = null
    var session: Session? = null
    var productDB: ProductDataBase? = null
    var productCount = 0
    var staticData: MutableList<Product> = mutableListOf()
    var sData:MutableList<Product> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cart.add(Product("0", "Terra Fries",  R.drawable.pcterra,"Flavored Fries","Sour & Cream", "Terra", 199.00, 0))
        cart.add(Product("1", "Giga Fries",  R.drawable.pcgiga,"Flavored Fries", "Barbeque", "Giga", 149.00, 0))
        cart.add(Product("2", "Mega Fries",  R.drawable.pcmega,"Flavored Fries","Chili Barbeque", "Mega", 99.00, 0))
        cart.add(Product("3", "Jumbo Fries",  R.drawable.pcjumbo,"Flavored Fries","Wasabi", "Jumbo", 79.00, 0))
        cart.add(Product("4", "Large Fries",  R.drawable.pclarge,"Flavored Fries", "Salted Caramel","Large", 55.00, 0))
        cart.add(Product("5", "Regular Fries",  R.drawable.pcregular,"Flavored Fries", "Regular","Cheddar", 35.00, 0))

        fm = supportFragmentManager
        staticData = StaticSizeData.getlists()
        sData = StaticData.getlists4()
        setSupportActionBar(mToolbar)

        menu = layoutInflater.inflate(R.layout.menu, null)
        mToolbar.addView(menu, 0, Toolbar.LayoutParams(Gravity.END))
        cartmenu = layoutInflater.inflate(R.layout.layout_cart, null)
        mToolbar.addView(cartmenu, 1, Toolbar.LayoutParams(Gravity.END))

        cartmenu?.setOnClickListener {
            setToolbar(false, "")
            fm!!.beginTransaction().apply {
                replace(R.id.main_frame, CheckOutFragment(), CheckOutFragment.TAG)
                addToBackStack(CheckOutFragment.TAG)
            }.commit()
        }

        setToolbar(true, "Potato Corner")

        mToolbar.setNavigationOnClickListener {
            onBackPressed()
        }



        rv_main1.layoutManager = GridLayoutManager(this, 4)
        rv_main1.adapter = ProductAdapter(this, StaticData.getlists())

        rv_main2.layoutManager = GridLayoutManager(this, 4)
        rv_main2.adapter = ProductAdapter(this, StaticData.getlists3())

        rv_main3.layoutManager = GridLayoutManager(this, 4)
        rv_main3.adapter = ProductAdapter(this, StaticData.getlists2())


        val menu = PopupMenu(this, menu_view)
        menu.inflate(R.menu.menu_pop_up)
        //menu.show()
        menu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_change_pass -> {

                }

                R.id.menu_logout -> {
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true

        }
        menu_view.setOnClickListener {
            menu.show()
        }


    }

    override fun onBackPressed() {

        if(fm?.backStackEntryCount == 2)
        {
            super.onBackPressed()
        }

        if (fm?.backStackEntryCount == 0) {
            if (cart.isNotEmpty()) {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Exit to Application")
                alert.setMessage("Do you want to save/update your cart items?")
                alert.setNegativeButton("No", { _, _ ->
                    super.onBackPressed()
                })
                alert.setPositiveButton("Yes", { _, _ ->
                    async(UI) {
                        bg {
                            productDB?.productDao()?.deleteAll()

                            for (crt in cart) {
                                productDB?.productDao()?.insert(crt)
                            }
                        }

                        Toast.makeText(this@MainActivity, "Cart items saved", Toast.LENGTH_SHORT).show()
                        super.onBackPressed()
                    }
                }).show()
            } else {
                async(UI) {
                    bg {
                        productDB?.productDao()?.deleteAll()
                    }
                }
                super.onBackPressed()
            }
        } else {
            setToolbar(true, "Potato Corner")
            super.onBackPressed()
        }
    }

    fun setToolbar(isMain: Boolean, mTitle: String) {
        title = mTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(!isMain)
        when {isMain -> {
            menu?.visibility = View.VISIBLE
            cartmenu?.visibility = View.VISIBLE
        }
            else -> {
                menu?.visibility = View.GONE
                cartmenu?.visibility = View.GONE
            }
        }
    }

    fun newFragment(fragment: SizeSelectionFragment, tag: String) {
        fm!!.beginTransaction().apply {
            replace(R.id.main_frame, fragment, tag)
            addToBackStack(tag)
        }.commit()
    }

    fun setCartCount(count: Int) {
        cartmenu?.tv_cart_count?.text = count.toString()
        productCount = count
    }
}

