interface Container<T> {
    fun add(element: T)
    fun remove(index: Int)
    fun update(index: Int, element: T)
    fun get(index: Int): T
    fun getAll(): List<T>
}

class CinemaContainer : Container<Cinema> {
    private val cinemas: MutableList<Cinema> = mutableListOf()

    override fun add(element: Cinema) {
        cinemas.add(element)
    }

    override fun remove(index: Int) {
        cinemas.removeAt(index)
    }

    override fun update(index: Int, element: Cinema) {
        cinemas[index] = element
    }

    override fun get(index: Int): Cinema {
        return cinemas[index]
    }

    override fun getAll(): List<Cinema> {
        return cinemas
    }
}