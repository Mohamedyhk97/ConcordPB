package com.concodrd.concordpb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Models.Employes;

public class DetailsActivity extends AppCompatActivity {

    TextView tv_employName,tv_employTitle,tv_employDep,tv_employBuliding,tv_employFloor,tv_employExtision,tv_employMobile,tv_employEmail;
    Button btnCall,btnSendMail;
    Intent intent;
    String phoneNumber ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        intent = getIntent();
        phoneNumber = intent.getStringExtra("mobile");



        Toast.makeText(this,intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();


        initViews();




    }

    private void initViews(){
        tv_employName = findViewById(R.id.empName);
        tv_employTitle = findViewById(R.id.empTitle);
        tv_employDep = findViewById(R.id.empDep);
        tv_employBuliding = findViewById(R.id.empBuliding);
        tv_employFloor = findViewById(R.id.empFloor);
        tv_employExtision = findViewById(R.id.empExtsion);
        tv_employMobile = findViewById(R.id.empMobileNumber);
        tv_employEmail = findViewById(R.id.empEmail);

        btnCall = findViewById(R.id.btn_call);
        btnSendMail = findViewById(R.id.btn_sendMail);


        tv_employName.setText("Name : " + intent.getStringExtra("name"));
        tv_employTitle.setText("Title : " + intent.getStringExtra("title"));
        tv_employDep.setText("Department : " + intent.getStringExtra("dep"));
        tv_employEmail.setText("E-mail : " + intent.getStringExtra("mail"));
        tv_employBuliding.setText("Buliding : "+intent.getStringExtra("buliding"));
        tv_employFloor.setText("Floor : "+intent.getStringExtra("floor"));
        tv_employMobile.setText("Mobile : "+ intent.getStringExtra("mobile"));
        tv_employExtision.setText("Extension Number : "+intent.getStringExtra("ext"));




        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",intent.getStringExtra("mail"), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });






    }
}
