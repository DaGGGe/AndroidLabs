package com.app.ghostretrofit.data.retrofit

object Common {
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient().create(RetrofitServices::class.java)
}