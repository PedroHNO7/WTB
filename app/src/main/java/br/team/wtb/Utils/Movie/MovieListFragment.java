package br.team.wtb.Utils.Movie;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.team.wtb.R;

public class MovieListFragment extends Fragment {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    // Método onCreateView que infla a interface e configura o RecyclerView
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflando o layout do fragmento
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Inicializando o RecyclerView e configurando o layout
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtendo a instância do repositório de filmes
        MovieRepository movieRepository = MovieRepository.getInstance();

        // Inicializando o adaptador do RecyclerView com a lista de filmes
        movieAdapter = new MovieAdapter(movieRepository.getMovies());

        // Definindo o adaptador no RecyclerView
        recyclerView.setAdapter(movieAdapter);

        // Retornando a view que foi inflada e configurada
        return view;
    }
}
