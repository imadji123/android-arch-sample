package com.imadji.arch.domain.usecase.type;

import io.reactivex.Single;

/**
 * Created by imadji on 06/20/2019.
 */

public interface SingleUseCase<T> {

    Single<T> execute();

}
