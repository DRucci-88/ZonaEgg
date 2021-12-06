package id.ac.umn.zonaegg.data

data class EateryFireStore(
    var name: String? = "",
    var category: String? = "",
    var rating: Double? = 0.0,
    var distance: Double? = 0.0,
    var photoBackground: String? = "",
    var zMenu : List<ServingFireStore> = listOf()
)
