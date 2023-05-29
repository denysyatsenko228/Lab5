package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.MovieRequest
import ua.kpi.its.lab.rest.dto.MovieResponse
import ua.kpi.its.lab.rest.entity.Movie
import ua.kpi.its.lab.rest.repository.MovieRepository
import ua.kpi.its.lab.rest.svc.MovieService
@Service
class MovieServiceImpl(private val movieRepository: MovieRepository) : MovieService {
    @PreAuthorize("hasAuthority('EDIT')")
    override fun createMovie(movieRequest: MovieRequest): MovieResponse {
        val movie = Movie(originalTitle = movieRequest.originalTitle, country = movieRequest.country, productionCompany = movieRequest.productionCompany)
        val savedMovie = movieRepository.save(movie)
        return MovieResponse.fromEntity(savedMovie)
    }

    @PreAuthorize("permitAll()")
    override fun getMovieById(id: Long): MovieResponse {
        val movie = movieRepository.findById(id).orElseThrow()
        return MovieResponse.fromEntity(movie)
    }

    @PreAuthorize("permitAll()")
    override fun getAllMovies(id: Long): MovieResponse {
        val movies = movieRepository.findAll().orElseThrow()
        return MovieResponse.fromEntity(movies)
    }

    @PreAuthorize("hasAuthority('EDIT')")
    override fun updateMovieById(id: Long, movieRequest: MovieRequest): MovieResponse {
        val movie = movieRepository.findById(id).orElseThrow()
        movie.startPoint = movieRequest.originalTitle
        movie.destination = movieRequest.country
        val updatedMovie = movieRepository.save(movie)
        return MovieResponse.fromEntity(updatedMovie)
    }

    @PreAuthorize("hasAuthority('EDIT')")
    override fun deleteMovieById(id: Long): Boolean {
        movieRepository.deleteById(id)
        return true
    }
}