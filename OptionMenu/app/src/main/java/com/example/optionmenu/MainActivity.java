package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mnuF:
                Toast.makeText(this, "Hej Flemsedreng", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuH:
                Snackbar snack = Snackbar.make(mainLayout, "Det sgu Henrik", Snackbar.LENGTH_INDEFINITE);
                snack.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snack.dismiss();
                    }
                });
                snack.show();
                break;
            case R.id.mnuJ:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Send på pension");
                dialog.setMessage("Vil du sende kære Jan på pension?");
                dialog.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Du sendte Jan på pension :´(", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Du lod Jan blive :)", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                break;
        }
        return true;
    }
}