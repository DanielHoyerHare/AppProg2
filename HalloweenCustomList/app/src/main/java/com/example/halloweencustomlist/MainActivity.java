package com.example.halloweencustomlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Abdi", "Hans kælenavn er Andreas", R.drawable.abdi));
        monsters.add(new Monster("Ahmed Sharkarji", "Stor dreng med stor mave", R.drawable.ahmed_sharkarji));
        monsters.add(new Monster("Daniel", "Det mig", R.drawable.daniel));
        monsters.add(new Monster("H4 klassen", "H4 i helhed", R.drawable.h4_klassen));
        monsters.add(new Monster("Jan", "Hr lære der meget klog", R.drawable.jan));
        monsters.add(new Monster("Kevin", "Bor i Jylland... så det :/", R.drawable.kevin));
        monsters.add(new Monster("Leonard", "Ad", R.drawable.leonard));
        monsters.add(new Monster("Magnus", "Tynd lang pind", R.drawable.magnus));
        monsters.add(new Monster("Marco", "Ham den lille der", R.drawable.marco));
        monsters.add(new Monster("Nicklas", "Langt lyst hår men ingen fregner", R.drawable.nicklas));
        monsters.add(new Monster("Nisha", "Den eneste af hun-kønnet i den nuværende klasse", R.drawable.nisha));
        monsters.add(new Monster("Wobin", "...", R.drawable.wobin));

        CustomAdapter adapter = new CustomAdapter(this, monsters);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}