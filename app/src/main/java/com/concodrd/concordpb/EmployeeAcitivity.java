package com.concodrd.concordpb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.CustomItemClickListener;
import Adapter.EmplpyesAdapter;
import Adapter.RecyclerViewAdapter;
import Models.Employes;

public class EmployeeAcitivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Employes> employesList = new ArrayList<Employes>();
    ConData conData;
    Intent getDepId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_acitivity);
        conData = new ConData(EmployeeAcitivity.this);
        getDepId=getIntent();
        getEmplyeeByDepID(getDepId.getStringExtra("depID"));

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(EmployeeAcitivity.this, LinearLayoutManager.VERTICAL, false));

        EmplpyesAdapter adapter = new EmplpyesAdapter(EmployeeAcitivity.this,employesList);

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Employes employes= employesList.get(position);
               Intent intent = new Intent(EmployeeAcitivity.this,DetailsActivity.class);
               intent.putExtra("name",employesList.get(position).getEmployeName());
                intent.putExtra("title",employesList.get(position).getEmployeTitle());
                intent.putExtra("dep",employesList.get(position).getEmployeDepartment());
                intent.putExtra("buliding",employesList.get(position).getEmployeBuliding());
                intent.putExtra("floor",employesList.get(position).getEmployeFloor());
                intent.putExtra("mail",employesList.get(position).getEmployeMail());
                intent.putExtra("ext",employesList.get(position).getEmployeExtesion());
                intent.putExtra("mobile",employesList.get(position).getEmployeMobile());


               startActivity(intent);
            }
        });




    }

    public void getEmplyeeByDepID(String id) {
        for (int i = 0; i < conData.getItEmployes().size(); i++)
        {
            Employes employes =  conData.getItEmployes().get(i);
            if (employes.getEmployeNameDepID().equals(id))
            employesList.add(employes);

        }
    }
}
