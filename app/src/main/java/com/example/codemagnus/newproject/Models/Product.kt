package com.example.codemagnus.newproject.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by CDI on 2/23/18
 */
@Entity(tableName = "cartData")
class Product :Parcelable {

    constructor()



    @PrimaryKey(autoGenerate = true)
    var dbId: Int = 0

    @ColumnInfo(name = "productId")
    var id: String = ""

    @ColumnInfo(name = "productName")
    var name: String = ""

    @ColumnInfo(name = "description")
    var description: String = ""

    @ColumnInfo(name = "imageUrl")
    var imgUrl = 0

    var category:String = ""

    var flavor:String = ""

    var size:String = ""

    var price: Double = 0.00

    var qty: Int = 0




    constructor(parcel: Parcel) : this() {
        dbId = parcel.readInt()
        id = parcel.readString()
        name = parcel.readString()
        description = parcel.readString()
        imgUrl = parcel.readInt()
        category = parcel.readString()
        flavor = parcel.readString()
        size = parcel.readString()
        price = parcel.readDouble()
        qty = parcel.readInt()
    }


    constructor(jsonObject: JSONObject){
        id = try {
            jsonObject.getString("id")
        }catch (e: JSONException){
            ""
        }

        name = try {
            jsonObject.getString("name")
        }catch (e: JSONException){
            ""
        }

        description = try {
            jsonObject.getString("description")
        }catch (e: JSONException){
            ""
        }

        price = try {
            jsonObject.getDouble("price")
        }catch (e: JSONException){
            0.00
        }

        imgUrl = try {
            jsonObject.getInt("imageUrl")
        }catch (e: JSONException){
            0
        }
    }



    constructor(name: String, category: String, flavor: String, size: String, price: Double, qty: Int) {
        this.name = name
        this.category = category
        this.flavor = flavor
        this.size = size
        this.price = price.toDouble()
        this.qty = qty
    }

    constructor(name: String, category: String, size: String, price: Double, qty: Int) {
        this.name = name
        this.category = category
        this.size = size
        this.price = price.toDouble()
        this.qty = qty
    }

    constructor(name: String, category: String, price: Double, qty: Int) {
        this.name = name
        this.category = category
        this.price = price
        this.qty = qty
    }

    constructor(name: String, category: String) {
        this.name = name
        this.category = category
    }

    constructor(name: String, category: String, flavor: String) {
        this.name = name
        this.category = category
        this.flavor = flavor
    }

    constructor(id: String, name: String, description: String, imgUrl: Int, category: String) {
        this.id = id
        this.name = name
        this.description = description
        this.imgUrl = imgUrl
        this.category = category
    }

    constructor(id: String, name: String, description: String, imgUrl: Int, category: String, flavor: String, price: Double) {
        this.id = id
        this.name = name
        this.description = description
        this.imgUrl = imgUrl
        this.category = category
        this.flavor = flavor
        this.price = price
    }

    constructor(id: String, name: String, description: String, imgUrl: Int, category: String, price: Double) {
        this.id = id
        this.name = name
        this.description = description
        this.imgUrl = imgUrl
        this.category = category
        this.price = price
    }

    constructor(id: String, imgUrl: Int, size: String) {
        this.id = id
        this.imgUrl = imgUrl
        this.size = size
    }

    constructor(id: String, imgUrl: Int, size: String, price: Double) {
        this.id = id
        this.imgUrl = imgUrl
        this.size = size
        this.price = price
    }

    constructor(id: String, name: String, imgUrl: Int) {
        this.id = id
        this.name = name
        this.imgUrl = imgUrl
    }

    constructor(id: String, name: String, imgUrl: Int, category: String) {
        this.id = id
        this.name = name
        this.imgUrl = imgUrl
        this.category = category
    }

    constructor(id: String, name: String, imgUrl: Int, category: String, flavor: String, size: String, price: Double, qty: Int) {
        this.id = id
        this.name = name
        this.imgUrl = imgUrl
        this.category = category
        this.flavor = flavor
        this.size = size
        this.price = price
        this.qty = qty
    }


    override fun toString(): String {
        val jsonObject = JSONObject()

        try {
            jsonObject.put("id", id)
            jsonObject.put("name", name)
            jsonObject.put("description", description)
            jsonObject.put("price", price)
            jsonObject.put("imageUrl", imgUrl)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return jsonObject.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dbId)
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(imgUrl)
        parcel.writeString(category)
        parcel.writeString(flavor)
        parcel.writeString(size)
        parcel.writeDouble(price)
        parcel.writeInt(qty)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

}