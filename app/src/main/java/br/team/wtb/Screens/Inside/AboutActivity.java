package br.team.wtb.Screens.Inside;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.team.wtb.R;
import br.team.wtb.Screens.Register.LoginActivity;
import br.team.wtb.Utils.Theme.ThemeManager;

public class AboutActivity extends AppCompatActivity {

    private LinearLayout switchContainer;

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

    }
}