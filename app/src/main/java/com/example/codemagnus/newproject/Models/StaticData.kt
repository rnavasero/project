package com.example.codemagnus.newproject.Models

import com.example.codemagnus.newproject.R

/**
 * Created by codemagnus on 3/20/18.
 */
class StaticData {
    companion object {
        fun getlists(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product(
                    "Cheddar",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Cheddar",
                    0.00
            ))
            product.add(Product(
                    "Barbeque",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Barbeque",
                    0.00
            ))
            product.add(Product(
                    "Salted Caramel",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Salted Caramel",
                    0.00
            ))
            product.add(Product(
                    "Wasabi",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Wasabi",
                    0.00
            ))
            product.add(Product(
                    "Sour and Cream",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Sour & Cream",
                    0.00
            ))
            product.add(Product(
                    "C. Barbeque",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Chili Barbeque",
                    0.00
            ))
            product.add(Product(
                    "Garlic Parmesan",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Garlic Parmesan",
                    0.00
            ))
            product.add(Product(
                    "Cinnamon & Sugar",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Cinnamon $ Sugar",
                    0.00
            ))
            return product


        }

        fun getlists2(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product(
                    "Softdrinks",
                    R.drawable.softdrinks,
                    "Beverages"
            ))


            product.add(Product(
                    "Iced Tea",
                    R.drawable.icedtead,
                    "Beverages"
            ))


            product.add(Product(
                    "Bottled Water",
                    R.drawable.water,
                    "Beverages"
            ))

            product.add(Product(
                    "Minute Maid",
                    R.drawable.minutemaid,
                    "Beverages"
            ))

            return product


        }

        fun getlists3(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product(
                    "Loopy Fries",
                    R.drawable.loopyfries,
                    "Fancy Fries"
            ))


            product.add(Product(
                    "Hash Brown",
                    R.drawable.hashbrown,
                    "Fancy Fries"
            ))


            product.add(Product(
                    "Jojos",
                    R.drawable.jojos,
                    "Fancy Fries"
            ))

            product.add(Product(
                    "Cheezy Fries",
                    R.drawable.cheese,
                    "Fancy Fries"
            ))

            return product


        }

        fun getlists4(): ArrayList<Product> {
            val product = ArrayList<Product>()
            product.add(Product(
                    R.drawable.cheese,
                    "Small"
            ))


            product.add(Product(
                    R.drawable.cheese,
                    "Medium"
            ))


            product.add(Product(
                    R.drawable.cheese,
                    "Large"
            ))

            return product


        }

    }
}