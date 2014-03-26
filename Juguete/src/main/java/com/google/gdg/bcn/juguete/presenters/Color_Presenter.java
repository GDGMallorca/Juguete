package com.google.gdg.bcn.juguete.presenters;

import com.google.gdg.bcn.juguete.models.Color_DataBase;
import com.google.gdg.bcn.juguete.framework.MVPActivity;
import com.google.gdg.bcn.juguete.framework.PresenterBase;
import com.google.gdg.bcn.juguete.views.Color_View;

import java.util.List;

public class Color_Presenter extends PresenterBase {

    public Color_Presenter(MVPActivity view) {
        super(view);
    }

    public void onClickButtonAdd() {
        // 0. Load needed models
        Color_DataBase dataBase = new Color_DataBase();

        // 1. get data from database [emulated]
        List<String> colors = dataBase.getColors();

        // 2. set new data to view (Generic View Should be cast to specific here)
        ((Color_View)view).loadData(colors);
    }

}
