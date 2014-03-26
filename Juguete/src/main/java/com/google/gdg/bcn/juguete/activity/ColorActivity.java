package com.google.gdg.bcn.juguete.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.gdg.bcn.juguete.presenter.ColorPresenter;


public class ColorActivity extends FragmentActivity {
    private ColorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ColorPresenter(this);
    }

}
