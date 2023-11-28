package com.adoyo.orbitallibrarry.model

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String?
)

data class PageInfo(
    val count: Int,
    val totalPages: Int, val previousPage: String?,
    val nextPage: String?
)

