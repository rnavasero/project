package com.example.codemagnus.newproject.Models

import com.example.codemagnus.newproject.R

/**
 * Created by codemagnus on 3/20/18.
 */
class StaticData {
    companion object {
        fun getlists(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product("0",
                    "Cheddar",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Cheddar",
                    0.00
            ))
            product.add(Product("1",
                    "Barbeque",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Barbeque",
                    0.00
            ))
            product.add(Product("2",
                    "Salted Caramel",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Salted Caramel",
                    0.00
            ))
            product.add(Product("3",
                    "Wasabi",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Wasabi",
                    0.00
            ))
            product.add(Product("4",
                    "Sour and Cream",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Sour & Cream",
                    0.00
            ))
            product.add(Product("5",
                    "C. Barbeque",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Chili Barbeque",
                    0.00
            ))
            product.add(Product("6",
                    "Garlic Parmesan",
                    "Description",
                    R.drawable.cheese,
                    "Flavored Fries",
                    "Garlic Parmesan",
                    0.00
            ))
            product.add(Product("7",
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
            product.add(Product("0",
                    "Softdrinks",
                    R.drawable.softdrinks,
                    "Beverages"
            ))


            product.add(Product("1",
                    "Iced Tea",
                    R.drawable.icedtead,
                    "Beverages"
            ))


            product.add(Product("2",
                    "Bottled Water",
                    R.drawable.water,
                    "Beverages"
            ))

            product.add(Product("3",
                    "Minute Maid",
                    R.drawable.minutemaid,
                    "Beverages"
            ))

            return product


        }

        fun getlists3(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product("0",
                    "Loopy Fries",
                    R.drawable.loopyfries,
                    "Fancy Fries"
            ))


            product.add(Product("1",
                    "Hash Brown",
                    R.drawable.hashbrown,
                    "Fancy Fries"
            ))


            product.add(Product("2",
                    "Jojos",
                    R.drawable.jojos,
                    "Fancy Fries"
            ))

            product.add(Product("3",
                    "Cheezy Fries",
                    R.drawable.cheese,
                    "Fancy Fries"
            ))

            return product


        }

        fun getlists4(): ArrayList<Product> {
            var product = ArrayList<Product>()
            product.add(Product("0",
                    "Small",
                    R.drawable.cheese
            ))


            product.add(Product("1",
                    "Medium",
                    R.drawable.cheese
            ))


            product.add(Product("2",
                    "Large",
                    R.drawable.cheese
            ))

            return product


        }

    }
}