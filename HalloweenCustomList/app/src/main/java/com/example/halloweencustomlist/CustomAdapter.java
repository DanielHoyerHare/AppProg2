package com.example.halloweencustomlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Monster> monsters;
    private MainActivity main;

    public CustomAdapter(MainActivity context, ArrayList<Monster> monsters) {
        this.monsters = monsters;
        this.main = context;
    }

    @Override
    public int getCount() {
        return monsters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Monster monster = monsters.get(position);
        View v = main.getLayoutInflater().inflate(R.layout.monster_item, null);

        ImageView img = v.findViewById(R.id.monsterImg);
        img.setImageResource(monster.getImgId());

        TextView name = v.findViewById(R.id.monsterName),
                desc = v.findViewById(R.id.monsterDesc);
        name.setText(monster.getName());
        desc.setText(monster.getDescription());

        Button btn = v.findViewById(R.id.btnDelete);
        btn.setText("Delete " + monster.getName());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monsters.remove(monster);
                notifyDataSetChanged();
            }
        });
        return v;
    }
}
