package dicoding.mobileprogramming.faishalammar.core.utils

import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.GenreResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.MovieResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.TvSeriesResponse

object DataDummy {

    val genreResponse = GenreResponse(12, "action")
    val genreResponse2 = GenreResponse(18, "fantasy")
    val arrGenreDummy = arrayListOf(genreResponse, genreResponse2)
    
    fun generateDummyMovies(): ArrayList<MoviesAndTvShowsEntity> {

        val movies = ArrayList<MoviesAndTvShowsEntity>()



        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Raya and The Last Dragon",
                "In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last dragon.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                true
            )
        )

        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                8.1f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Fantasy"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Godzilla vs Kong",
                "The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Thriller"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "4",
                "Mortal Kombat",
                "MMA fighter Cole Young seeks out Earth's greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.",
                6.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "5",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "6",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "7",
                "Mare of Easttown ",
                "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Crime", "Mystery", "Drama"),
                true
            )
        )

        movies.add(
            MoviesAndTvShowsEntity(
                "8",
                "Stowaway",
                "A three-person crew on a mission to Mars faces an impossible choice when an unplanned passenger jeopardizes the lives of everyone on board.",
                5.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Mystery", "Drama"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "9",
                "The Walking Dead",
                "Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins and must lead a group of survivors to stay alive.",
                8.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Zombie", "Thriller", "Drama"),
                true
            )
        )

        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Raya and The Last Dragon",
                "In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last dragon.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                true

            )
        )

        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                8.1f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Fantasy"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Godzilla vs Kong",
                "The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Thriller"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "4",
                "Mortal Kombat",
                "MMA fighter Cole Young seeks out Earth's greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.",
                6.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure"),
                true
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "5",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                true
            )
        )

        return movies
    }

    fun generateDummySeries(): ArrayList<MoviesAndTvShowsEntity> {

        val movies = ArrayList<MoviesAndTvShowsEntity>()

        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false

            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false

            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false

            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false

            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "1",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false

            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "2",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Comedy"),
                false
            )
        )
        movies.add(
            MoviesAndTvShowsEntity(
                "3",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("Action", "Adventure", "Drama"),
                false
            )
        )
        return movies
    }

    fun generateRemoteDummyMovies(): ArrayList<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse("s01",
                "Raya and The Last Dragon",
                "In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last dragon.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )

        movies.add(
            MovieResponse("s02",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                8.1f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "18" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s03",
                "Godzilla vs Kong",
                "The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s04",
                "Mortal Kombat",
                "MMA fighter Cole Young seeks out Earth's greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.",
                6.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s05",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s06",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s07",
                "Mare of Easttown ",
                "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("80", "80", "80" ),
                    arrGenreDummy
            )
        )

        movies.add(
            MovieResponse("s08",
                "Stowaway",
                "A three-person crew on a mission to Mars faces an impossible choice when an unplanned passenger jeopardizes the lives of everyone on board.",
                5.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "80", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s09",
                "The Walking Dead",
                "Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins and must lead a group of survivors to stay alive.",
                8.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("80", "80", "80" ),
                    arrGenreDummy
            )
        )

        movies.add(
            MovieResponse("s01",
                "Raya and The Last Dragon",
                "In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last dragon.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )

        movies.add(
            MovieResponse("s02",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                8.1f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "18" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s03",
                "Godzilla vs Kong",
                "The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s04",
                "Mortal Kombat",
                "MMA fighter Cole Young seeks out Earth's greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.",
                6.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18" ),
                    arrGenreDummy
            )
        )
        movies.add(
            MovieResponse("s05",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )

        return movies
    }

    fun generateRemoteDummySeries(): ArrayList<TvSeriesResponse> {

        val movies = ArrayList<TvSeriesResponse>()

        movies.add(
            TvSeriesResponse("s01",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s02",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s03",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s01",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s02",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s03",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s01",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s02",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s03",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s01",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s02",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s03",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s01",
                "Shadow and Bone",
                "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.",
                8.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s02",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s03",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s02",
                "Love and Monsters",
                "Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.",
                7.0f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        movies.add(
            TvSeriesResponse("s03",
                "Falcon and the Winter Soldier ",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                7.5f,
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf("18", "18", "80" ),
                    arrGenreDummy
            )
        )
        return movies
    }


}