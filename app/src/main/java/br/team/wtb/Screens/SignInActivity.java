package br.team.wtb.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.team.wtb.R;
import br.team.wtb.Utils.ThemeManager;

public class SignInActivity extends AppCompatActivity {

    // Contêiner para o switch do tema
    private LinearLayout switchContainer, loginLink;

    private EditText loginInput, passwordInput, nameInput, cellphoneInput;

    private Button signBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicializa o ThemeManager e aplica o tema atual
        ThemeManager themeManager = ThemeManager.getInstance(this);
        themeManager.applyTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EdgeToEdge.enable(this);

        // Encontra o contêiner do switch personalizado
        switchContainer = findViewById(R.id.theme_switch);

        // Configura o ouvinte de clique para o switch
        switchContainer.setOnClickListener(v -> {
            themeManager.toggleTheme(SignInActivity.this);
            recreate();
        });

        // Encontra os elementos (EditText e Botão)
        loginInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        nameInput = findViewById(R.id.name_input);
        cellphoneInput = findViewById(R.id.cellphone_input);

        signBtn = findViewById(R.id.btn_sign);
        loginLink = findViewById(R.id.option_login);

        signBtn.setOnClickListener(view -> {

        });

        loginLink.setOnClickListener(view -> finish());


    }
}