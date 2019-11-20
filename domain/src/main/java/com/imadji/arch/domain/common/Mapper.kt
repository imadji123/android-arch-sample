package com.imadji.arch.domain.common

abstract class Mapper<E, T> {
    abstract fun mapFrom(from: E): T
}