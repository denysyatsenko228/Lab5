package ua.kpi.its.lab.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.kpi.its.lab.rest.entity.Movie


@Repository
interface MovieRepository : JpaRepository<Movie, Long>