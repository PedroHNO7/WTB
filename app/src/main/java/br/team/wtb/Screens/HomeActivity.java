package br.team.wtb.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.team.wtb.Model.Movie;
import br.team.wtb.R;
import br.team.wtb.Utils.Movie.MovieAdapter;
import br.team.wtb.Utils.Theme.ThemeManager;

public class HomeActivity extends AppCompatActivity {

    // Contêiner para o switch do tema
    private LinearLayout switchContainer;

    //  Contêiner e Botão do Menu
    private ImageButton btnMenu;
    private DrawerLayout drawerLayout;

    private List<Movie> movieList;
    private MovieAdapter movieAdapter;
    private RecyclerView moviesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicializa o ThemeManager e aplica o tema atual
        ThemeManager themeManager = ThemeManager.getInstance(this);
        themeManager.applyTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        EdgeToEdge.enable(this);

        // Inicializa o contêiner do tema
        switchContainer = findViewById(R.id.theme_switch);

        // Configura o ouvinte de clique para o switch
        switchContainer.setOnClickListener(v -> {
            themeManager.toggleTheme(HomeActivity.this);
            recreate();
        });

        // Inicializa o contêiner do menu e botão
        btnMenu = findViewById(R.id.btn_menu);
        drawerLayout = findViewById(R.id.home_activity);

        // Configura o ouvinte de clique para o botão do menu
        btnMenu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer if it's open
            } else {
                drawerLayout.openDrawer(GravityCompat.START); // Open the drawer if it's closed
            }
        });

        // Inicializa o menu com Manager
        moviesContainer = findViewById(R.id.movies_container);
        moviesContainer.setLayoutManager(new LinearLayoutManager(this));

        // Adiciona a lista de filmes
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie(R.drawable.img_poster_whiplash, "Whiplash", 2014, 5, false, "yes"));
        movieList.add(new Movie(R.drawable.img_poster_whiplash, "Whiplash", 2014, 5, false, "yes"));

        // Passa a lista pro Adapter
        movieAdapter = new MovieAdapter(movieList);
        moviesContainer.setAdapter(movieAdapter);
    }
}