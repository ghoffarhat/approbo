package com.example.acceuilrobo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this line hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        navigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.bodycontainer, new first()).commit();
        navigationView.setSelectedItemId(R.id.first);

        navigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.first:
                        fragment=new first();
                        break;

                    case R.id.second:
                        fragment=new second();
                        break;
                    case R.id.third:
                        fragment=new third();
                        break;
                    case R.id.forth:
                        fragment=new forth();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bodycontainer, fragment).commit();
            }
        });

    }
}