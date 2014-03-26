package com.google.gdg.bcn.juguete.framework;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class MVPActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApp.getInstance().setActualView(this);
        init();
    }

    public void execute(String function, Object[] params){
        MainApp.getInstance()
            .execute(getClass().getSimpleName(), function, params);
    }

    protected abstract void init();
}
