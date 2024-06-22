package com.example.movieapp.models

data class MovieModel(
    val id: String,
    val  title: String,
    val genres: List<String>,
    val director: String,
    val img: String,
    val rating: Double,
    val description: String,
    val actors: List<String>,
)

fun getAllMovies(): List<MovieModel> {
    return listOf(
        MovieModel(
            id = "1",
            title = "Joker",
            genres = listOf("Crime","Drama", "Thriller"),
            description = "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
            director = "Todd Phillips" ,
            img = "https://imageio.forbes.com/specials-images/imageserve/5d6a0922fead28000892b2b7/Official-poster-for-Warner-s--Joker-/960x0.jpg?format=jpg&width=1440",
            actors = listOf("Joaquin Phoenix", "Zazie Beetz", "Robert De Niro", "Brett Cullen"),
            rating = 8.4
        ),
        MovieModel(
            id = "2",
            title = "Batman Under The Blood Hood",
            genres = listOf("Animation","Action","Crime", "Drama"),
            description = "When a sadistic serial killer begins murdering key political figures in Gotham, The Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
            director = "Matt Reeves" ,
            img = "https://ntvb.tmsimg.com/assets/p8129393_v_h10_ab.jpg?w=1280&h=720",
            actors = listOf("Bruce Greenwood", "John DiMaggio", "Jensen Ackles", "Jason Isaacs"),
            rating = 7.8
        ),
        MovieModel(
            id = "3",
            title = "Damsel",
            genres = listOf("Action","Crime", "Drama"),
            description = "A young woman agrees to marry a handsome prince -- only to discover it was all a trap. She is thrown into a cave with a fire-breathing dragon and must rely solely on her wits and will to survive.",
            director = "Juan Carlos Fresnadillo" ,
            img = "https://m.media-amazon.com/images/M/MV5BODRiMTA4NGMtOTQzZC00OWFjLWFmODctMjY2ZTcwYjI5NDMyXkEyXkFqcGdeQXVyMDc5ODIzMw@@._V1_FMjpg_UX1000_.jpg",
            actors = listOf("Millie Bobby Brown", "Angela Bassett", "Nick Robinson", "Milo Twomey"),
            rating = 7.8
        ),
        MovieModel(
            id = "4",
            title = "Rebel Moon",
            genres = listOf("Action","Crime", "Drama"),
            description = "A colony on the edge of the galaxy fights for survival against a tyrannical ruling force, relying on the efforts of a small group of rebel.",
            director = "Zack Snyder" ,
            img = "https://upload.wikimedia.org/wikipedia/en/d/dd/Rebel_Moon_%E2%80%93_Part_Two_The_Scargiver_poster.jpg",
            actors = listOf("Sofia Boutella", "Djimon Hounsou", "Ed Skrein", "Michiel Huisman"),
            rating = 7.8
        ),
        MovieModel(
            id = "5",
            title = "Lift",
            genres = listOf("Action","Crime", "Drama"),
            description = "A master thief is wooed by his ex-girlfriend and the FBI to pull off an impossible heist with his international crew on a 777 passenger flight from London to Zurich.",
            director = "Matt Reeves" ,
            img = "https://upload.wikimedia.org/wikipedia/en/c/c0/Lift_2024_poster.webp",
            actors = listOf("Kevin Hart", "Gugu Mbatha-Raw", "Sam Worthington", "Yun Jee Kim"),
            rating = 7.8
        ),
        MovieModel(
            id = "6",
            title = "Atlas",
            genres = listOf("Action","Crime", "Drama", "Sci-fi"),
            description = "A brilliant data analyst with a deep distrust of AI finds it may be her only hope when a mission to capture a renegade robot goes awry.",
            director = "Brad Peyton" ,
            img = "https://upload.wikimedia.org/wikipedia/en/f/f4/Atlas_2024_film_poster.png",
            actors = listOf("Jennifer Lopez", "Sterling K. Brown", "Lana Parrilla", "Ashley J. Hicks"),
            rating = 7.8
        ),
    )
}
