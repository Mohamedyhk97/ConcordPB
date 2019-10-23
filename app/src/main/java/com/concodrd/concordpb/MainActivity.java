package com.concodrd.concordpb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

import Models.Employes;

public class MainActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 4000;
    ImageView iv_concordLogo;
    Button btn_next;
    ConData conData;
    EditText ed_extsionNumber;
    int enteredExtsion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conData= new ConData(MainActivity.this);

        iv_concordLogo = findViewById(R.id.iv_concordLogo);
        btn_next = findViewById(R.id.button);
        ed_extsionNumber = findViewById(R.id.editText);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkText = ed_extsionNumber.getText().toString();
                if (checkText.matches("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Extension Number", Toast.LENGTH_SHORT).show();
                    YoYo.with(Techniques.Shake)
                            .duration(3000)
                            .repeat(0)
                            .playOn(btn_next);
                }else {

                    int entertNumber = Integer.parseInt(ed_extsionNumber.getText().toString());
                    checkExtision(entertNumber);

                }

            }
        });

        YoYo.with(Techniques.Landing)
                .duration(3000)
                .repeat(0)
                .playOn(iv_concordLogo);
            }

            public void checkExtision(int enteredExtsion){
                ArrayList<Employes> employes = new ArrayList<Employes>();
                for (int i = 0 ; i < conData.getItEmployes().size();i++)
                {
                    Employes employes1 = conData.getItEmployes().get(i);
                    if (employes1.getEmployeExtesion().equals(String.valueOf(enteredExtsion))){
                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,DepartmentActivity.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(this, "Invalid Extension Number", Toast.LENGTH_SHORT).show();

                    }

                }




            }






}

