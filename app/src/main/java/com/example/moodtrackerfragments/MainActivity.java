package com.example.moodtrackerfragments;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView nav = findViewById(R.id.bottom_navigation);
        EditText et = findViewById(R.id.etName);

        nav.setOnItemSelectedListener(item -> {
            Fragment f = null;
            int id = item.getItemId();
            int c = Color.WHITE;

            if (id == R.id.nav_happy) {
                f = new HappyFragment();
                c = Color.YELLOW;
            } else if (id == R.id.nav_neutral) {
                f = new NeutralFragment();
                c = Color.RED;
            } else if (id == R.id.nav_sad) {
                f = new SadFragment();
                c = Color.BLUE;
            }

            if (f != null) {
                nav.setBackgroundColor(c);

                String s = et.getText().toString();
                Bundle b = new Bundle();
                b.putString("name", s);
                f.setArguments(b);

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out) // האנימציה שביקשת
                        .replace(R.id.fragment_container, f)
                        .commit();
            }
            return true;
        });
    }
}

