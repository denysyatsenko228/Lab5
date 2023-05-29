package ua.kpi.its.lab.rest.dto

class MovieRequest {
    var originalTitle: String? = null
        private set
    var country: String? = null
        private set
    var productionCompany: String? = null
        private set

    constructor()
    constructor(originalTitle: String?, country: String?, productionCompany: String?) {
        this.originalTitle = originalTitle
        this.country = country
        this.productionCompany = productionCompany
    }
}


class MovieResponse {
    var id: Long? = null
        private set
    var originalTitle: String? = null
        private set
    var country: String? = null
        private set
    var productionCompany: String? = null
        private set

    constructor()
    constructor(id: Long?, originalTitle: String?, country: String?, productionCompany: String?) {
        this.id = id
        this.originalTitle = originalTitle
        this.country = country
        this.productionCompany = productionCompany
    }
}


class CinemaRequest {
    var name: String? = null
        private set
    var address: String? = null
        private set
    var numOfSeats: Int? = null
        private set

    constructor()
    constructor(name: String?, address: String?, numOfSeats: Int?) {
        this.name = name
        this.address = address
        this.numOfSeats = numOfSeats
    }
}


class CinemaResponse {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var address: String? = null
        private set
    var numOfSeats: Int? = null
        private set

    constructor()
    constructor(id: Long?, name: String?, address: String?, numOfSeats: Int?) {
        this.id = id
        this.name = name
        this.address = address
        this.numOfSeats = numOfSeats
    }
}

