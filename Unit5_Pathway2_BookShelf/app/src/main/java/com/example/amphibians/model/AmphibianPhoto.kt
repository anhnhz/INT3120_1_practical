package com.example.amphibians.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibianPhoto(
    val name: String,
    @SerialName(value = "img_src")
    val imgSrc: String,
    val type: String,
    val description: String,

)