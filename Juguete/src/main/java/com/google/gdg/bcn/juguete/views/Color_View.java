package com.google.gdg.bcn.juguete.views;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gdg.bcn.juguete.R;
import com.google.gdg.bcn.juguete.framework.MVPActivity;

import java.util.ArrayList;
import java.util.List;

public class Color_View extends MVPActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ArrayAdapter<String> adapter;
    private ListView list;

    protected void init() {
        // 0. set view
        setContentView(R.layout.activity_main);

        // 1. init adapter & listview
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        list = (ListView)findViewById(R.id.activity_color_listview);

        // 2. set adapter to list && itemclicklistener
        list.setOnItemClickListener(this);
        list.setAdapter(adapter);

        // 3. clicklistener button
        findViewById(R.id.activity_color_button_add).setOnClickListener(this);
    }

    public void loadData(List<String> colors) {
        for(String color : colors) {
            adapter.add(color);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_color_button_add:
                execute("onClickButtonAdd", null);
            break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String color = adapter.getItem(position);
        Toast.makeText(this, color, Toast.LENGTH_SHORT).show();
    }
}
