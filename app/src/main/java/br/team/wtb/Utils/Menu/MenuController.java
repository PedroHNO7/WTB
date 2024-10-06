package br.team.wtb.Utils.Menu;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import br.team.wtb.R;
import br.team.wtb.Screens.Inside.AboutActivity;
import br.team.wtb.Screens.Inside.HomeActivity;

public class MenuController {

    private final Activity activity;

    // Construtor para iniciar baseado na Activity
    public MenuController(Activity activity) {
        this.activity = activity;
    }

    // Adicionando os botões do menu com seus ouvintes
    public void setupMenu() {
        TextView homeItem = activity.findViewById(R.id.home_item);
        TextView shareItem = activity.findViewById(R.id.share_item);
        TextView aboutItem = activity.findViewById(R.id.about_item);
        TextView favItem = activity.findViewById(R.id.fav_item);
        TextView exitItem = activity.findViewById(R.id.exit_item);

        homeItem.setOnClickListener(v -> {
            Intent intent = new Intent(activity, HomeActivity.class);
            activity.startActivity(intent);
        });

        shareItem.setOnClickListener(v -> {

        });

        aboutItem.setOnClickListener(v -> {
            Intent intent = new Intent(activity, AboutActivity.class);
            activity.startActivity(intent);
        });

        favItem.setOnClickListener(v -> {
            Intent intent = new Intent(activity, HomeActivity.class);
            activity.startActivity(intent);
        });

        exitItem.setOnClickListener(v -> {
            activity.finish();
        });
    }
}
