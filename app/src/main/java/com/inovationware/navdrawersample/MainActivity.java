package com.inovationware.navdrawersample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    AppBarConfiguration actionBarConfiguration;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.hostForNavGraph);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);

        actionBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.usersFragment, R.id.settingsFragment)
                .setOpenableLayout(drawerLayout)
                .build();

        NavigationUI.setupWithNavController(navigationView, navController);

        //show hamburger icon
        NavigationUI.setupActionBarWithNavController(this, navController, actionBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.hostForNavGraph);
        return NavigationUI.navigateUp(navController, actionBarConfiguration) || super.onSupportNavigateUp();
    }
}