package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.MovieRequest
import ua.kpi.its.lab.rest.dto.MovieResponse
interface MovieService {
    fun createMovie(movieRequest: MovieRequest): MovieResponse
    fun getMovieById(id: Long): MovieResponse
    fun updateMovieById(id: Long, movieRequest: MovieRequest): MovieResponse
    fun deleteMovieById(id: Long): Boolean
}