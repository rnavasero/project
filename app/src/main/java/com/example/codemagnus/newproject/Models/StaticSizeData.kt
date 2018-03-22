package com.example.codemagnus.newproject.Models

import com.example.codemagnus.newproject.R

/**
 * Created by codemagnus on 3/20/18.
 */
class StaticSizeData {
    companion object {
        fun getlists(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product("0",
                    R.drawable.pcregular,
                    "Regular",
                    33.00
            ))
            product.add(Product("1",
                    R.drawable.pclarge,
                    "Large",
                    55.00
            ))
            product.add(Product("2",
                    R.drawable.pcjumbo,
                    "Jumbo",
                    79.00
            ))
            product.add(Product("3",
                    R.drawable.pcmega,
                    "Mega",
                    99.00
            ))
            product.add(Product("4",
                    R.drawable.pcgiga,
                    "Giga",
                    149.00
            ))
            product.add(Product("5",
                    R.drawable.pcterra,
                    "Terra",
                    199.00
            ))
            return product


        }

    }
}