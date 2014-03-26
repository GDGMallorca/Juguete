package com.google.gdg.bcn.juguete.presenter;

import android.support.v4.app.FragmentActivity;

import com.google.gdg.bcn.juguete.model.ColorDataBase;
import com.google.gdg.bcn.juguete.view.ColorView;

import java.util.List;


public class ColorPresenter {
    private ColorView view;
    private ColorDataBase dataBase;

    public ColorPresenter(FragmentActivity fragmentActivity) {
        view = new ColorView(fragmentActivity, this);
        dataBase = new ColorDataBase();
    }

    public void onClickButtonAdd() {
        // 0. get data from database [emulated]
        List<String> colors = dataBase.getColors();

        // 1. set new data to view
        view.loadData(colors);
    }

}
