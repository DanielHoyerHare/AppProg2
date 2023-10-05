package com.example.finalprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.example.finalprojectapp.models.People;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<People> pList;
    private MainActivity main;

    public CustomAdapter(MainActivity context, ArrayList<People> pList) {
        this.pList = pList;
        this.main = context;
    }

    @Override
    public int getCount() {
        return pList.size();
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
        People p = pList.get(position);
        View v = main.getLayoutInflater().inflate(R.layout.people_item, null);

        ImageView img = v.findViewById(R.id.imgStar);
        if (p.getFav()) {
            img.setImageResource(R.drawable.star_selected);
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p.getFav()){
                    p.setFav(false);
                }
                else{
                    p.setFav(true);
                }
                People result = ApiLayer.updatePeople(p);
                if (result.getFav()){
                    img.setImageResource(R.drawable.star_selected);
                    Toast.makeText(main, result.getName() + " was favorited!", Toast.LENGTH_LONG).show();
                    return;
                }
                img.setImageResource(R.drawable.star);
                Toast.makeText(main, result.getName() + " was unfavorited!", Toast.LENGTH_LONG).show();
            }
        });

        TextView name = v.findViewById(R.id.txtName),
                tel = v.findViewById(R.id.txtTel),
                note = v.findViewById(R.id.txtNote);
        name.setText(p.getName());
        tel.setText(p.getTel());
        note.setText(p.getNote());

        LinearLayout item = v.findViewById(R.id.item);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.launchPeopleDetail(p.getId());
            }
        });

        return v;
    }
}
