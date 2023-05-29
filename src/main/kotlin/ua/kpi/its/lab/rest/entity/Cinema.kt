package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate
@Entity
@Table(name = "cinema")
data class Cinema(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String,
    val address: String,
    val launchDate: LocalDate,
    val numOfSeats: Int,
    val numOfScreens: Int,
    val soundTechnology: String,
    val is3DAvailable: Boolean,
    @OneToMany(mappedBy = "movies", cascade = [CascadeType.ALL], orphanRemoval = true)
    val movies: List<Movie>
) : Comparable<Cinema> {
    override fun compareTo(cinema: Cinema): Int {
        val compare = name.compareTo(cinema.name)
        return if (compare != 0) compare else address.compareTo(cinema.address)
    }
}