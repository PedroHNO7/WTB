package br.team.wtb.Screens.Inside;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.team.wtb.Model.Developer;
import br.team.wtb.Model.Movie;
import br.team.wtb.R;
import br.team.wtb.Screens.Register.LoginActivity;
import br.team.wtb.Utils.Developer.DeveloperAdapter;
import br.team.wtb.Utils.Menu.MenuController;
import br.team.wtb.Utils.Movie.MovieAdapter;
import br.team.wtb.Utils.Theme.ThemeManager;

public class AboutActivity extends AppCompatActivity {

    private LinearLayout switchContainer;

    //  Contêiner e Botão do Menu
    private ImageButton btnMenu;
    private DrawerLayout drawerLayout;

    private List<Developer> devList;
    private DeveloperAdapter devAdapter;
    private RecyclerView devsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicializa o ThemeManager e aplica o tema atual
        ThemeManager themeManager = ThemeManager.getInstance(this);
        themeManager.applyTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        EdgeToEdge.enable(this);

        // Encontra o contêiner do switch personalizado
        switchContainer = findViewById(R.id.theme_switch);

        // Configura o ouvinte de clique para o switch
        switchContainer.setOnClickListener(v -> {

            themeManager.toggleTheme(AboutActivity.this);
            recreate();
        });

        // Inicializa o contêiner do menu e botão
        btnMenu = findViewById(R.id.btn_menu);
        drawerLayout = findViewById(R.id.about_activity);

        // Inicializa o menu com Manager
        MenuController menuController = new MenuController(this);
        menuController.setupMenu();

        // Configura o ouvinte de clique para o botão do menu
        btnMenu.setOnClickListener(v -> {

            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Inicializa o menu com Manager
        devsContainer = findViewById(R.id.dev_container);
        devsContainer.setLayoutManager(new LinearLayoutManager(this));

        // Adiciona a lista de desenvolvedores
        devList = new ArrayList<Developer>();
        devList.add(new Developer(R.drawable.img_poster_duque, "DevDuque", getString(R.string.one_dev_role), getString(R.string.one_dev_description), "https://github.com/devduque/"));

        devList.add(new Developer(R.drawable.img_poster_pedro, "Pedro H.N Oliveira", getString(R.string.two_dev_role), getString(R.string.two_dev_description), "https://github.com/PedroHNO7"));

        devList.add(new Developer(R.drawable.img_poster_vicente, "Vicente do Carmo", getString(R.string.two_dev_role), getString(R.string.two_dev_description), "https://github.com/vicentecss"));

        // Passa a lista pro Adapter
        devAdapter = new DeveloperAdapter(devList);
        devsContainer.setAdapter(devAdapter);
    }
}