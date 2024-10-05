package br.team.wtb.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import br.team.wtb.R;

public class CustomThemeSwitch extends LinearLayout {

    // Slider do botão do interruptor
    private RelativeLayout toggleSlider;

    // Bola do botão do interruptor
    private View toggleBall;

    // Rastreia o estado do tema atual
    private boolean isDarkMode;

    // Construtor que aceita atributos XML
    public CustomThemeSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // Método de inicialização
    private void init(Context context) {

        // Infla o layout custom_switch.xml e associa ao layout atual
        LayoutInflater.from(context).inflate(R.layout.custom_switch, this, true);

        toggleSlider = findViewById(R.id.toggle_slider);
        toggleBall = findViewById(R.id.toggle_ball);

        ThemeManager themeManager = ThemeManager.getInstance(context);
        isDarkMode = themeManager.getCurrentTheme(context) == R.style.Theme_WTB_Dark;

        updateToggleBallPosition();

        // Configura o ouvinte de clique para alternar o tema
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                themeManager.toggleTheme(context);

                isDarkMode = !isDarkMode;

                updateToggleBallPosition();
                ((AppCompatActivity) context).recreate();
            }
        });
    }

    // Atualiza a posição da bola do toggle com base no estado atual do tema
    private void updateToggleBallPosition() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) toggleBall.getLayoutParams();

        if (isDarkMode) {

            // Move a bola do toggle para o início
            params.addRule(RelativeLayout.ALIGN_PARENT_START);
            params.removeRule(RelativeLayout.ALIGN_PARENT_END);
        } else {

            // Move a bola do toggle para o final
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.removeRule(RelativeLayout.ALIGN_PARENT_START);
        }

        toggleBall.setLayoutParams(params);

        toggleBall.requestLayout();
    }
}
