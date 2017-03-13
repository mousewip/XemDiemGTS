package com.htp.mousewip.xemdiemgts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mouse on 28/02/2017.
 */

public class ListAdapter extends ArrayAdapter<HocPhan> {

    public ListAdapter(Context context, int resource, List<HocPhan> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.activity_hoc_phan, null);
        }
        HocPhan p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txtSTT = (TextView) view.findViewById(R.id.txtSTT);
            txtSTT.setText(p.stt);
            TextView txtMaHP = (TextView) view.findViewById(R.id.txtMaHP);
            txtMaHP.setText(p.msHP);
            TextView txtTenHP = (TextView) view.findViewById(R.id.txtTenHP);
            txtTenHP.setText(p.tenHP);
            TextView txtLopHoc = (TextView) view.findViewById(R.id.txtLopHoc);
            txtLopHoc.setText(p.lopHoc);
            TextView txtSoTC = (TextView) view.findViewById(R.id.txtSoTC);
            txtSoTC.setText(p.soTC);
            TextView txtDiemQT = (TextView) view.findViewById(R.id.txtDiemQT);
            txtDiemQT.setText(p.diemQT);
            TextView txtDiemThi = (TextView) view.findViewById(R.id.txtDiemThi);
            txtDiemThi.setText(p.diemThi);
            TextView txtDiem10 = (TextView) view.findViewById(R.id.txtDiem10);
            txtDiem10.setText(p.diem10);
            TextView txtDiem4 = (TextView) view.findViewById(R.id.txtDiem4);
            txtDiem4.setText(p.diem4);
            TextView txtDiemChu = (TextView) view.findViewById(R.id.txtDiemChu);
            txtDiemChu.setText(p.diemChu);
            TextView txtXepLoai = (TextView) view.findViewById(R.id.txtXepLoai);
            txtXepLoai.setText(p.xepLoai);
            TextView txtGhiChu = (TextView) view.findViewById(R.id.txtGhiChu);
            txtGhiChu.setText(p.ghiChu);


        }
        return view;
    }

}
