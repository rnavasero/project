package com.example.codemagnus.newproject.Models

import com.example.codemagnus.newproject.R

/**
 * Created by codemagnus on 3/20/18.
 */
class StaticSizeData {
    companion object {
        fun getlists(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product(
                    R.drawable.pcregular,
                    "Regular",
                    33.00
            ))
            product.add(Product(
                    R.drawable.pclarge,
                    "Large",
                    55.00
            ))
            product.add(Product(
                    R.drawable.pcjumbo,
                    "Jumbo",
                    79.00
            ))
            product.add(Product(
                    R.drawable.pcmega,
                    "Mega",
                    99.00
            ))
            product.add(Product(
                    R.drawable.pcgiga,
                    "Giga",
                    149.00
            ))
            product.add(Product(
                    R.drawable.pcterra,
                    "Terra",
                    199.00
            ))
            return product


        }

    }
}