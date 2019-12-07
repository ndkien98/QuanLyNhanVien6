package com.ndkien98.quanlynhanvien6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    ListView admin_listview;
    ListAdapter listAdapter;
    SQLDataHandler sqlDataHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        admin_listview=this.findViewById(R.id.admin_listview);
        sqlDataHandler = new SQLDataHandler(this);
        ArrayList<NhanVien> list = sqlDataHandler.getAllNhanVien();
        listAdapter = new ListAdapter(this,list);
        admin_listview.setAdapter(listAdapter);

    }
}
