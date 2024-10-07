package br.team.wtb.Utils.Movie;

import java.util.ArrayList;
import java.util.List;

import br.team.wtb.Model.Movie;
import br.team.wtb.R;

public class MovieRepository {
    private static MovieRepository instance;

    // Lista de filmes
    private List<Movie> movieList;

    // Construtor privado para impedir que a classe seja instanciada diretamente fora da própria classe
    private MovieRepository() {
        movieList = new ArrayList<>();
        // Adiciona filmes de exemplo ou busca de um banco de dados/API
        movieList.add(new Movie(R.drawable.img_poster_whiplash, "Whiplash", 2014, 5, false, "https://www.youtube.com/watch?v=iTgk3WbTErk&pp=ygUQd2hpcGxhc2ggdHJhaWxlcg%3D%3D"));
        movieList.add(new Movie(R.drawable.img_poster_whiplash, "Whiplash", 2014, 5, false, "https://www.youtube.com/watch?v=iTgk3WbTErk&pp=ygUQd2hpcGxhc2ggdHJhaWxlcg%3D%3D"));
    }

    public static synchronized MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    // Método para retornar a lista de filmes
    public List<Movie> getMovies() {
        return movieList;
    }

    // Método para retornar uma lista de filmes que são favoritos
    public List<Movie> getFavoriteMovies() {
        List<Movie> favoriteMovies = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getFavorite()) {
                favoriteMovies.add(movie);
            }
        }
        return favoriteMovies;
    }

    // Método para adicionar um filme à lista
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
}
