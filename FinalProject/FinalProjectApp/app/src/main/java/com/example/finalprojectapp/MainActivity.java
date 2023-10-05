package com.example.finalprojectapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalprojectapp.models.People;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;

    ImageView btnAdd;

    private Intent intent;
    ActivityResultLauncher<Intent> peopleDetailActivityLauncher;

    //Strings til intent
    public static final String INPUT_ID_TO_PEOPLE_DETAIL = "InputIdToPeopleDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewPeople);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        peopleDetailActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            updateList();
                        }
                    }
                });
        updateList();
    }

    public void updateList(){
        ArrayList<People> pList = ApiLayer.getAllPeople();

        CustomAdapter adapter = new CustomAdapter(this, pList);

        listView.setAdapter(adapter);
    }

    public void launchPeopleDetail(int id){
        intent = new Intent(this, PeopleDetail.class);

        intent.putExtra(INPUT_ID_TO_PEOPLE_DETAIL, id);

        peopleDetailActivityLauncher.launch(intent);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this, PeopleDetail.class);

        peopleDetailActivityLauncher.launch(intent);
    }
}