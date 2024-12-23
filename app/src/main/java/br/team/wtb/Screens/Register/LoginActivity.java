package br.team.wtb.Screens.Register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import br.team.wtb.Database.UserDAO;
import br.team.wtb.Model.User;
import br.team.wtb.R;
import br.team.wtb.Screens.Inside.HomeActivity;
import br.team.wtb.Utils.Theme.ThemeManager;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout switchContainer, signLink;
    private EditText loginInput, passwordInput;
    private Button loginBtn;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager themeManager = ThemeManager.getInstance(this);
        themeManager.applyTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EdgeToEdge.enable(this);

        switchContainer = findViewById(R.id.theme_switch);
        switchContainer.setOnClickListener(v -> {
            themeManager.toggleTheme(LoginActivity.this);
            recreate();
        });

        loginInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        loginBtn = findViewById(R.id.btn_login);
        signLink = findViewById(R.id.option_sign);

        userDAO = new UserDAO(this);  // Inicializa o DAO

        loginBtn.setOnClickListener(view -> loginUser());
        signLink.setOnClickListener(view -> {
            Intent signScreen = new Intent(LoginActivity.this, SignInActivity.class);
            startActivity(signScreen);
        });
    }

    private void loginUser() {
        String email = loginInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = userDAO.login(email, password);  // Tenta fazer realizar o login

        if (user != null) {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
            Intent homeScreen = new Intent(LoginActivity.this, HomeActivity.class);
            System.out.println("Usuário logado com sucessso");
            startActivity(homeScreen);
            finish();  // Fecha a tela de login
        } else {
            Toast.makeText(this, "Email ou senha incorretos.", Toast.LENGTH_SHORT).show();
        }
    }
}
