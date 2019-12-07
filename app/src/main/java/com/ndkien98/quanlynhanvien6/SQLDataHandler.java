package com.ndkien98.quanlynhanvien6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLDataHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="QuanLyNhanVien";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NHANVIEN = "nhanVien";
    public static final String TABLE_QUYEN="quyen";

    public static final String KEY_NHAN_VIEN_ID="id";
    public static final String KEY_NHAN_VIEN_NAME = "hoTen";
    public static final String KEY_NHAN_VIEN_USERNAME= "username";
    public static final String KEY_NHAN_VIEN_PASSWORD = "password";
    public static final String KEY_NHAN_VIEN_NAMSINH="namSinh";
    public static final String KEY_NHAN_VIEN_PHONG_BAN="phongBan";
    public static final String KEY_NHAN_VIEN_LUONG="luong";
    public static final String KEY_NHAN_VIEN_DIACHI="diaChi";
    public static final String KEY_NHAN_VIEN_QUYEN="quyen_id";

    public static final String KEY_QUYEN_ID="id";
    public static final String KEY_QUYEN_NAME="name";


    public SQLDataHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_nhanvien_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s VARCHAR ,%s VARCHAR , %s VARCHAR, %s VARCHAR, %s VARCHAR,%s INTEGER ,%s INTEGER ,%s INTEGER )",
                TABLE_NHANVIEN,KEY_NHAN_VIEN_ID
                ,KEY_NHAN_VIEN_NAME,KEY_NHAN_VIEN_USERNAME
                ,KEY_NHAN_VIEN_PASSWORD,KEY_NHAN_VIEN_DIACHI,
                KEY_NHAN_VIEN_PHONG_BAN,KEY_NHAN_VIEN_NAMSINH,
                KEY_NHAN_VIEN_LUONG,KEY_NHAN_VIEN_QUYEN);

        String create_quyen_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s VARCHAR )",
                        TABLE_QUYEN,KEY_QUYEN_ID,KEY_QUYEN_NAME);
        sqLiteDatabase.execSQL(create_quyen_table);

        sqLiteDatabase.execSQL(create_nhanvien_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String drop_nhanvien_table = String.format("DROP TABLE IF EXISTS %s",TABLE_NHANVIEN);
        sqLiteDatabase.execSQL(drop_nhanvien_table);
        String drop_quyen_table = String.format("DROP TABLE IF EXISTS %s",TABLE_QUYEN);
        sqLiteDatabase.execSQL(drop_quyen_table);
        onCreate(sqLiteDatabase);
    }


    public void addNhanVien (NhanVien nhanVien){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NHAN_VIEN_ID,nhanVien.getId());
        values.put(KEY_NHAN_VIEN_NAME,nhanVien.getHoTen());
        values.put(KEY_NHAN_VIEN_USERNAME,nhanVien.getUsername());
        values.put(KEY_NHAN_VIEN_PASSWORD,nhanVien.getPassword());
        values.put(KEY_NHAN_VIEN_DIACHI,nhanVien.getDiaChi());
        values.put(KEY_NHAN_VIEN_PHONG_BAN,nhanVien.getPhongBan());
        values.put(KEY_NHAN_VIEN_NAMSINH,nhanVien.getNamSinh());
        values.put(KEY_NHAN_VIEN_LUONG,nhanVien.getLuong());
        values.put(KEY_NHAN_VIEN_QUYEN,nhanVien.getQuyen_id());

        sqLiteDatabase.insert(TABLE_NHANVIEN,null,values);
        sqLiteDatabase.close();
    }


    public ArrayList<NhanVien> getAllNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(String.format("select * from %s", TABLE_NHANVIEN),null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()== false){

            int id = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_ID));
            String name= cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_NAME));
            String username = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_PASSWORD));
            String diachi = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_DIACHI));
            String phongban = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_PHONG_BAN));
            int namsinh = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_NAMSINH));
            int luong = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_LUONG));
            int quyen = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_QUYEN));

            NhanVien nhanVien = new NhanVien(id,name,username,password,diachi,phongban,namsinh,luong,quyen);
            list.add(nhanVien);
            cursor.moveToNext();
        }
        return list;
    }

    public NhanVien getNhanVien(String username,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //Cursor cursor =sqLiteDatabase.query(TABLE_NHANVIEN,null,KEY_NHAN_VIEN_USERNAME+"=?"+KEY_NHAN_VIEN_PASSWORD+"=?",new String []{username,password},null,null,null);

        Cursor cursor = sqLiteDatabase.rawQuery(String.format("select * from %s where %s='%s' and %s='%s'", TABLE_NHANVIEN,KEY_NHAN_VIEN_USERNAME,username,KEY_NHAN_VIEN_PASSWORD,password),null);
        NhanVien nhanVien = null;
        try {
            if (cursor!=null){
                cursor.moveToNext();
            }
            int id = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_ID));
            String name = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_NAME));
            String usename1 = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_USERNAME));
            String pass = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_PASSWORD));
            String diachi = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_DIACHI));
            String phongban = cursor.getString(cursor.getColumnIndex(KEY_NHAN_VIEN_PHONG_BAN));
            int namsinh = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_NAMSINH));
            int luong = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_LUONG));
            int quyen  = cursor.getInt(cursor.getColumnIndex(KEY_NHAN_VIEN_QUYEN));
            nhanVien = new NhanVien(id,name,usename1,pass,diachi,phongban,namsinh,luong,quyen);
        }catch (Exception e){
            System.out.println("User null");
        }
        return nhanVien;
    }

}
