package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="movie")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val originalTitle: String,
    val country: String,
    val productionCompany: String,
    val runningTime: Int,
    val budget: Double,
    val releaseDate: LocalDate,
    val hasCertificate: Boolean,
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    val cinema: Cinema,
) : Comparable<Movie> {
    override fun compareTo(movie: Movie): Int {
        val compare = originalTitle.compareTo(movie.originalTitle)
        return if (compare != 0) compare else budget.compareTo(movie.budget) +
                country.compareTo(movie.country) +
                releaseDate.compareTo(movie.releaseDate)
    }
}