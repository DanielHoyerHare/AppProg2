package com.example.calculator3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView billede;
    String mode;

    EditText input1, input2, result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billede = findViewById(R.id.billede);
        registerForContextMenu(billede);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(Menu.NONE, 0, Menu.NONE, "+");
        menu.add(Menu.NONE, 1, Menu.NONE, "-");
        menu.add(Menu.NONE, 2, Menu.NONE, "*");
        menu.add(Menu.NONE, 3, Menu.NONE, "/");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 0:
                billede.setImageResource(R.drawable.knap_plus);
                mode = "plus";
                break;
            case 1:
                billede.setImageResource(R.drawable.knap_minus);
                mode = "minus";
                break;
            case 2:
                billede.setImageResource(R.drawable.knap_mul);
                mode = "mul";
                break;
            case 3:
                billede.setImageResource(R.drawable.knap_div);
                mode = "div";
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (input1.getText().toString().matches("")) {
            Toast.makeText(this, "Du glemte at skrive noget i tekst felt 1!", Toast.LENGTH_LONG).show();
            return;
        }
        if (input2.getText().toString().matches("")) {
            Toast.makeText(this, "Du glemte at skrive noget i tekst felt 2!", Toast.LENGTH_LONG).show();
            return;
        }
        if (mode == null) {
            result.setText("err");
            Toast.makeText(this, "Du glemte at vælge et mode!", Toast.LENGTH_LONG).show();
            return;
        }
        double a = Double.parseDouble(input1.getText().toString()),
                b = Double.parseDouble(input2.getText().toString()),
                c = 0;
        switch(mode){
            case "plus":
                c = a + b;
                break;
            case "minus":
                c = a - b;
                break;
            case "mul":
                c = a * b;
                break;
            case "div":
                c = a / b;
                break;
        }
        result.setText(Double.toString(c));
    }
}