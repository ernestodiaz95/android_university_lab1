package com.codepath.bestsellerlistapp.models

import com.google.gson.annotations.SerializedName

class BestSellerBook {
    @SerializedName("rank")
    var rank = 0

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("author")
    var author: String? = null

    @SerializedName("book_image")
    var bookImageUrl: String? = null

    @SerializedName("description")
    var description: String? = null
}