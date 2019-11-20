package com.imadji.arch.domain.usecase

import com.imadji.arch.domain.common.TestUtil.Companion.mockMovies
import com.imadji.arch.domain.repository.MovieRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations

class GetPopularMoviesTest {

    @Mock
    lateinit var movieRepository: MovieRepository

    private lateinit var getPopularMovies: GetPopularMovies

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getPopularMovies = GetPopularMovies(movieRepository)
    }

    @Test
    fun `should return popular movies data`() {
        val popularMovies = mockMovies()

        `when`(movieRepository.getPopularMovies()).thenReturn(Single.just(popularMovies))

        getPopularMovies.execute().test()
                .assertResult(popularMovies)

        verify(movieRepository).getPopularMovies()
        verifyNoMoreInteractions(movieRepository)
    }
}