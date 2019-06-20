package com.imadji.arch.sample.di.home;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by imadji on 06/20/2019.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface HomeScope {
}
