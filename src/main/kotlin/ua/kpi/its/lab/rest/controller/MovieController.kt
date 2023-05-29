package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.MovieRequest
import ua.kpi.its.lab.rest.dto.MovieResponse
import ua.kpi.its.lab.rest.svc.impl.MovieServiceImpl

@RestController
@RequestMapping("/movie")
class MovieController(private val movieServiceImpl: MovieServiceImpl) {
    @PostMapping
    fun createMovie(@RequestBody req: MovieRequest): ResponseEntity<MovieResponse> {
        val resp = movieServiceImpl.createMovie(req)
        return ResponseEntity(resp, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getAllMovies(@PathVariable id: Long): ResponseEntity<MovieResponse> {
        val resp = movieServiceImpl.getAllMovies()
        return ResponseEntity(resp, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: Long): ResponseEntity<MovieResponse> {
        val resp = movieServiceImpl.getMovieById(id)
        return ResponseEntity(resp, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateMovieById(@PathVariable id: Long, @RequestBody req: MovieRequest): ResponseEntity<MovieResponse> {
        val reps = movieServiceImpl.updateMovieById(id, req)
        return ResponseEntity(reps, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteMovieById(@PathVariable id: Long): ResponseEntity<Void> {
        movieServiceImpl.deleteMovieById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}