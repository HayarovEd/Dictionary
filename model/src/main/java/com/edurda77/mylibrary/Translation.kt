package com.edurda77.mylibrary

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Translation(
    @SerializedName(TEXT)
    val textTranslation: String
): Serializable
