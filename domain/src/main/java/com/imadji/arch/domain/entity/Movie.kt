package com.imadji.arch.domain.entity

data class Movie(
        val id: Long,
        val title: String,
        val posterUrl: String = ""
)