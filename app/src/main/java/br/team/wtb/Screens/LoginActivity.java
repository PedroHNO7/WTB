package br.team.wtb.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import br.team.wtb.R;
import br.team.wtb.Utils.ThemeManager;

public class LoginActivity extends AppCompatActivity {

    // Contêiner para o switch do tema
    private LinearLayout switchContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicializa o ThemeManager e aplica o tema atual
        ThemeManager themeManager = ThemeManager.getInstance(this);
        themeManager.applyTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Encontra o contêiner do switch personalizado
        switchContainer = findViewById(R.id.theme_switch);

        // Configura o ouvinte de clique para o switch
        switchContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themeManager.toggleTheme(LoginActivity.this);
                recreate();
            }
        });
    }
}
