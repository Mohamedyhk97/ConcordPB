package com.concodrd.concordpb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.CustomItemClickListener;
import Adapter.RecyclerViewAdapter;
import Models.Department;

public class DepartmentActivity extends AppCompatActivity {
    ArrayList<Integer> depImages = new ArrayList<Integer>();
    ArrayList<Department> departments = new ArrayList<Department>();
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        initDepRecycler();


    }

    private void initDepRecycler() {


        depImages.add(R.drawable.it);
       departments.add(new Department("1","IT Department/ادارة نظم المعلومات"));

        depImages.add(R.drawable.policeman);
        departments.add(new Department("2","Security Department/ادارة الامن"));

        depImages.add(R.drawable.medal);
        departments.add(new Department("3","Quality Department/ادارة الجودة"));

        depImages.add(R.drawable.report);
        departments.add(new Department("4","Financial Department/القطاع المالى"));

        depImages.add(R.drawable.engineer);
        departments.add(new Department("5","Technical Office Department/مكتب فنى"));

        depImages.add(R.drawable.tunnel);
        departments.add(new Department("6","Tunnels purchases/مشريات الانفاق"));


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(DepartmentActivity.this, LinearLayoutManager.VERTICAL, false));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(DepartmentActivity.this, depImages, departments);

        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(DepartmentActivity.this,EmployeeAcitivity.class);
                intent.putExtra("depID",departments.get(position).getDepId());
                startActivity(intent);

                      }
        });

    }
}
