package com.ndkien98.quanlynhanvien6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Activity activity ;
    ArrayList<NhanVien> list;

    public ListAdapter(Activity activity,ArrayList listNV){
        this.activity = activity;
        this.list = listNV;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater =this.activity.getLayoutInflater();
        view = inflater.inflate(R.layout.items,null);

        TextView items_txt_name,items_txt_phongBan,items_txt_id;
        items_txt_name = view.findViewById(R.id.items_txt_name);
        items_txt_phongBan = view.findViewById(R.id.items_txt_phongBan);
        items_txt_id=view.findViewById(R.id.items_txt_id);

        items_txt_id.setText(list.get(i).getId()+"");
        items_txt_name.setText(list.get(i).getHoTen());
        items_txt_phongBan.setText(list.get(i).getPhongBan());

        return view;
    }
}
