package com.ndkien98.quanlynhanvien6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListAdapter listAdapter;
    ListView listView;
    SQLDataHandler sqlDataHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }




    /*
     listView = this.findViewById(R.id.home_listview);
        sqlDataHandler = new SQLDataHandler(this);
        NhanVien nhanVien = sqlDataHandler.getNhanVien("admin","1234567");
        if (nhanVien==null){
            System.out.println("Khong thay nv");
        }else System.out.println(nhanVien.toString());

        ArrayList<NhanVien> list ;


        list = sqlDataHandler.getAllNhanVien();
        listAdapter = new ListAdapter(this,list);
        listView.setAdapter(listAdapter);

     */

}
