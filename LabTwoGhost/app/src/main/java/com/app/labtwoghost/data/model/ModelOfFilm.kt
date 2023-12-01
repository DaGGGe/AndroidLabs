package com.app.labtwoghost.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//дата модель для фільмів
@Parcelize
data class ModelOfFilm(
    val image:String,val name:String,val genre:String,val details:String
): Parcelable