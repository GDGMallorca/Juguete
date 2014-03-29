package com.google.gdg.bcn.juguete.framework;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.lang.reflect.InvocationTargetException;

public abstract class ViewBase extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected abstract void init();
}
