package com.evan.android.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by laila-usr on 05/11/2016.
 */
public class ListAdapterItemPeople extends ArrayAdapter<ItemPeople> {

    private Context context;
    private ArrayList<ItemPeople> list;


    public ListAdapterItemPeople(Context context, ArrayList<ItemPeople> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ItemPeople itemPosition = this.list.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null);

        TextView textViewName = (TextView) convertView.findViewById(R.id.txt_idName);
        textViewName.setText(itemPosition.getColName());
        TextView textViewSchool = (TextView) convertView.findViewById(R.id.txt_idTel);
        textViewSchool.setText(itemPosition.getColTel());

//        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.deleteBox);
//        if(itemPosition.isShowButton())
//            checkBox.setVisibility(View.VISIBLE);
//        else
//            checkBox.setVisibility(View.GONE);
//
//        checkBox.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (checkBox.isChecked()) {
//                    itemPosition.setChecked(true);
//                    Log.d("select", "selected " + itemPosition.getName());
//                } else
//                    itemPosition.setChecked(false);
//            }
//
//        });

        return convertView;
    }
}
