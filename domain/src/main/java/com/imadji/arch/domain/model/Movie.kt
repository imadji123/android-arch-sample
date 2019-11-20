package com.imadji.arch.domain.model

data class Movie(
        val id: Long,
        val title: String,
        val posterUrl: String = ""
)