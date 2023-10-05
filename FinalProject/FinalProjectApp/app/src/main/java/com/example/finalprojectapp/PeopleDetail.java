package com.example.finalprojectapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectapp.models.HairColor;
import com.example.finalprojectapp.models.People;
import com.example.finalprojectapp.models.ProgLang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeopleDetail extends AppCompatActivity implements View.OnClickListener {

    Intent intent;

    People p;

    TextView txtPeopleTitle, txtId;
    EditText inputName, inputTel, inputAddress, inputNote;

    CheckBox chkBoxFav;

    Spinner spinnerHairColor;

    RadioGroup rdgProgLang;

    Button btnSend, btnDelete, btnCancel;

    String state = "add";

    int Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);

        txtPeopleTitle = findViewById(R.id.txtPeopleTitle);
        txtId = findViewById(R.id.txtId);

        inputName = findViewById(R.id.inputName);
        inputTel = findViewById(R.id.inputTel);
        inputAddress = findViewById(R.id.inputAddress);
        inputNote = findViewById(R.id.inputNote);

        chkBoxFav = findViewById(R.id.chkBoxFav);

        spinnerHairColor = findViewById(R.id.spinnerHairColor);

        ArrayList<HairColor> hcList = new ArrayList<>();
        hcList.add(new HairColor(0, "Choose Hair color"));
        hcList.addAll(ApiLayer.getAllHairColors());

        ArrayAdapter<HairColor> adapter = new ArrayAdapter<HairColor>(
                this,
                R.layout.customerspinnerlayout, hcList
                );

        spinnerHairColor.setAdapter(adapter);

        rdgProgLang = findViewById(R.id.rdgProgLang);
        ArrayList<ProgLang> plList = ApiLayer.getAllProgLangs();
        final RadioButton[] rbList = new RadioButton[plList.size()];
        for (int i = 0; i < plList.size(); i++){
            rbList[i] = new RadioButton(this);
            rbList[i].setText(plList.get(i).getLang());
            rbList[i].setTextSize(20);
            rbList[i].setPadding(0,0,50,0);
            rbList[i].setId(plList.get(i).getId());
            rdgProgLang.addView(rbList[i]);
        }

        btnSend = findViewById(R.id.btnSend);
        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);

        btnSend.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        intent = getIntent();
        Id = intent.getIntExtra(MainActivity.INPUT_ID_TO_PEOPLE_DETAIL, 0);

        if (Id == 0){
            return;
        }

        state = "edit";

        p = ApiLayer.getPeopleById(Id);

        txtPeopleTitle.setText("Edit " + p.getName() + "!");
        txtId.setText(String.valueOf(p.getId()));
        inputName.setText(p.getName());
        inputTel.setText(p.getTel());
        inputAddress.setText(p.getAddress());
        inputNote.setText(p.getNote());
        chkBoxFav.setChecked(p.getFav());
        spinnerHairColor.setSelection(p.getHairColor());
        rdgProgLang.check(p.getProgLang());

        btnSend.setText("Update");
        btnDelete.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCancel:
                setResult(RESULT_CANCELED, intent);
                finish();
                break;
            case R.id.btnDelete:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(PeopleDetail.this);
                dialogBuilder.setTitle("Delete");
                dialogBuilder.setMessage("Are you sure that you want to delete " + p.getName() + "?");
                dialogBuilder.setNegativeButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ApiLayer.deletePeopleById(Id);
                                setResult(RESULT_OK, intent);
                                finish();
                            }
                        });

                dialogBuilder.setPositiveButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = dialogBuilder.create();
                alert.show();
                break;
            case R.id.btnSend:
                if (!AssertInfo()){
                    break;
                }
                People p = new People(inputName.getText().toString(),
                        inputTel.getText().toString(),
                        inputAddress.getText().toString(),
                        inputNote.getText().toString(),
                        chkBoxFav.isChecked(),
                        (int) spinnerHairColor.getSelectedItemId(),
                        rdgProgLang.getCheckedRadioButtonId());
                if (state == "edit"){
                    p.setId(Id);
                    ApiLayer.updatePeople(p);
                }
                else {
                    ApiLayer.addPeople(p);
                }
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    // Tjekker om alt information er iorden
    public boolean AssertInfo(){
        // Assert på name input
        if (inputName.getText().toString().matches("")){
            Toast.makeText(this, "Error: Name is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!inputName.getText().toString().matches("[a-zA-ZæÆøØåÅ]+")){
            Toast.makeText(this, "Error: Name contains numbers og special characters", Toast.LENGTH_LONG).show();
            return false;
        }
        if (inputName.getText().toString().length() < 2) {
            Toast.makeText(this, "Error: Name is too short, has to be 2 characters or longer", Toast.LENGTH_LONG).show();
            return false;
        }

        // Assert på Phone input
        if (inputTel.getText().toString().matches("")){
            Toast.makeText(this, "Error: Phone is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!inputTel.getText().toString().matches("[0-9]+")){
            Toast.makeText(this, "Error: Phone can only contain numbers", Toast.LENGTH_LONG).show();
            return false;
        }
        if (inputTel.getText().toString().length() < 8) {
            Toast.makeText(this, "Error: Phone is too short, has to be 8-15 characters long", Toast.LENGTH_LONG).show();
            return false;
        }
        if (inputTel.getText().toString().length() > 15) {
            Toast.makeText(this, "Error: Phone is too long, has to be 8-15 characters long", Toast.LENGTH_LONG).show();
            return false;
        }

        // Assert på Address input
        if (inputAddress.getText().toString().matches("")){
            Toast.makeText(this, "Error: Address is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        String addressRegex = "([A-zæøåÆØÅé.]{2,40}\\s)*" +
                "[A-zæÆøØåÅ]*[0-9]+,\\s" +
                "([0-9]+.?\\s[tvTV]*[thTH]*[mfMF]*,\\s)" +
                "?[0-9]{2,5}\\s[A-zæøåÆØÅé]{2,40}";
        if (!inputAddress.getText().toString().matches(addressRegex)){
            Toast.makeText(this, "Error: Address is not valid", Toast.LENGTH_LONG).show();
            return false;
        }

        // Assert på hair color
        if (spinnerHairColor.getSelectedItemId() == 0) {
            Toast.makeText(this, "Error: Hair color has not been chosen", Toast.LENGTH_LONG).show();
            return false;
        }

        // Assert på programming language
        if (rdgProgLang.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Error: Programming Language has not been chosen", Toast.LENGTH_LONG).show();
            return false;
        }

        // Hvis alt er som det skal være returner den true
        return true;
    }
}