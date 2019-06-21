package com.imadji.arch.domain.common;

/**
 * Created by imadji on 06/21/2019.
 */

public abstract class Mapper<E, T> {
    public abstract T mapFrom(E from);
}
