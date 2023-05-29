package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.CinemaRequest
import ua.kpi.its.lab.rest.dto.CinemaResponse
import ua.kpi.its.lab.rest.svc.impl.CinemaServiceImpl


@RestController
@RequestMapping("/api/cinema")
class CinemaController {

    private final lateinit var cinemaServiceImpl: CinemaServiceImpl;

    @Autowired
    fun CinemaController(cinemaServiceImpl1: CinemaServiceImpl) {
        this.cinemaServiceImpl = cinemaServiceImpl1;
    }

    @PostMapping("/")
    fun createCinema(@Valid @RequestBody cinemaRequest: CinemaRequest?): ResponseEntity<CinemaResponse>? {
        val cinemaResponse: CinemaResponse? = cinemaRequest?.let { cinemaServiceImpl.createCinema(it) }
        return ResponseEntity.status(HttpStatus.CREATED).body<CinemaResponse>(cinemaResponse)
    }

    @GetMapping("/{id}")
    fun getCinemaById(@PathVariable Long id): ResponseEntity<CinemaResponse>? {
        val cinemaResponse: CinemaResponse = cinemaServiceImpl.getCinemaById(id);
        return ResponseEntity.ok(cinemaResponse);
    }

    @PutMapping("/{id}")
    fun updateCinemaById(
        @PathVariable id: Long,
        @Valid @RequestBody cinemaRequest: CinemaRequest?
    ): ResponseEntity<CinemaResponse>? {
        val cinemaResponse: CinemaResponse? = cinemaRequest?.let { cinemaServiceImpl.updateCinemaById(id, it) }
        return ResponseEntity.ok<CinemaResponse>(cinemaResponse)
    }

    @DeleteMapping("/{id}")
    fun deleteCinemaById(@PathVariable id: Long): ResponseEntity<Void?>? {
        val isDeleteSuccess: Boolean = cinemaServiceImpl.deleteCinemaById(id)
        if (!isDeleteSuccess) {
            println("Cinema deleting failed! Cinema with ID:'$id' not found")
        }
        return ResponseEntity.noContent().build()
    }
}