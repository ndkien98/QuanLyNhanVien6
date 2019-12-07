package com.ndkien98.quanlynhanvien6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login_txt_username,login_txt_passwoord;
    Button login_bt;
    SQLDataHandler sqlDataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_txt_username=this.findViewById(R.id.login_txt_username);
        login_txt_passwoord=this.findViewById(R.id.login_txt_password);
        login_bt=this.findViewById(R.id.login_bt_login);
        sqlDataHandler = new SQLDataHandler(this);

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = login_txt_username.getText().toString();
                String password = login_txt_passwoord.getText().toString();
                NhanVien nhanVien = sqlDataHandler.getNhanVien(username,password);
                if (nhanVien!=null){
                    if (nhanVien.getQuyen_id()==1){
                        Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }else Toast.makeText(getApplicationContext(),"Username or password error",Toast.LENGTH_LONG).show();



            }
        });

    }
}
