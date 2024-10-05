package br.team.wtb.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import br.team.wtb.R;
import br.team.wtb.Utils.Theme.ThemeManager;

public class LoginActivity extends AppCompatActivity {

    // Contêiner para o switch do tema
    private LinearLayout switchContainer, signLink;

    private EditText loginInput, passwordInput;

    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicializa o ThemeManager e aplica o tema atual
        ThemeManager themeManager = ThemeManager.getInstance(this);
        themeManager.applyTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EdgeToEdge.enable(this);

        // Encontra o contêiner do switch personalizado
        switchContainer = findViewById(R.id.theme_switch);

        // Configura o ouvinte de clique para o switch
        switchContainer.setOnClickListener(v -> {

            themeManager.toggleTheme(LoginActivity.this);
            recreate();
        });

        // Encontra os elementos (EditText e Botão)
        loginInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);

        loginBtn = findViewById(R.id.btn_login);
        signLink = findViewById(R.id.option_sign);

        loginBtn.setOnClickListener(view -> {
            Intent homeScreen = new Intent(LoginActivity.this, HomeActivity.class);

            startActivity(homeScreen);
        });

        signLink.setOnClickListener(view -> {

            Intent signScreen = new Intent(LoginActivity.this, SignInActivity.class);

            startActivity(signScreen);
        });
    }
}
