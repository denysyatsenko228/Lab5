package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.CinemaRequest
import ua.kpi.its.lab.rest.dto.CinemaResponse

interface CinemaService {
    fun createCinema(cinemaRequest: CinemaRequest): CinemaResponse
    fun getCinemaById(id: Long): CinemaResponse
    fun updateCinemaById(id: Long, cinemaRequest: CinemaRequest): CinemaResponse
    fun deleteCinemaById(id: Long): Boolean
}