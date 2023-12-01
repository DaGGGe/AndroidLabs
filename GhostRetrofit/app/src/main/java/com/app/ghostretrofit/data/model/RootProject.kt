package com.app.ghostretrofit.data.model

import com.google.gson.annotations.SerializedName


data class RootProject(
  @SerializedName("Search") var Search: ArrayList<Search> = arrayListOf(),
  @SerializedName("totalResults") var totalResults: String? = null,
  @SerializedName("Response") var Response: String? = null
)