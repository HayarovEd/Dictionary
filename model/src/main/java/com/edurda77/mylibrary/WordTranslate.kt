package com.edurda77.mylibrary

import com.edurda77.mylibrary.Meanings
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WordTranslate(
    @SerializedName(TEXT)
    val text: String,
    @SerializedName(MEANINGS)
    val meanings:List<Meanings>
):Serializable
