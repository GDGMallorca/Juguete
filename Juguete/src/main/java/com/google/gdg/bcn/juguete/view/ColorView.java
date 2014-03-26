package com.google.gdg.bcn.juguete.view;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gdg.bcn.juguete.R;
import com.google.gdg.bcn.juguete.presenter.ColorPresenter;

import java.util.ArrayList;
import java.util.List;

public class ColorView implements View.OnClickListener, AdapterView.OnItemClickListener {
    private FragmentActivity mFragmentActivity;     // activity
    private ColorPresenter mPresenter;              // presenter

    private ArrayAdapter<String> adapter;
    private ListView list;

    public ColorView (FragmentActivity fragmentActivity, ColorPresenter presenter) {
        mFragmentActivity = fragmentActivity;
        mPresenter = presenter;

        init();
    }


    private void init() {
        // 0. set view
        mFragmentActivity.setContentView(R.layout.activity_main);

        // 1. init adapter & listview
        adapter = new ArrayAdapter<String>(mFragmentActivity, android.R.layout.simple_list_item_1, new ArrayList<String>());
        list = (ListView)mFragmentActivity.findViewById(R.id.activity_color_listview);

        // 2. set adapter to list && itemclicklistener
        list.setOnItemClickListener(this);
        list.setAdapter(adapter);


        // 3. clicklistener button
        mFragmentActivity.findViewById(R.id.activity_color_button_add).setOnClickListener(this);
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
                mPresenter.onClickButtonAdd();
            break;

        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String color = adapter.getItem(position);
        Toast.makeText(mFragmentActivity, color, Toast.LENGTH_SHORT).show();
    }

}
