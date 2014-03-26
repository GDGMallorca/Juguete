package com.google.gdg.bcn.juguete.models;

import java.util.ArrayList;
import java.util.List;

public class Color_DataBase {
    private static int count = 0;

    public List<String> getColors() {

        List<String> colors = new ArrayList<String>();
        colors.add("Color " + count++);
        colors.add("Color " + count++);
        colors.add("Color " + count++);

        return colors;
    }

}
