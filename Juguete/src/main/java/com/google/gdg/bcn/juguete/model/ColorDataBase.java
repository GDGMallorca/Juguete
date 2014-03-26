package com.google.gdg.bcn.juguete.model;

import java.util.ArrayList;
import java.util.List;

public class ColorDataBase {
    private static int count = 0;

    public List<String> getColors() {

        List<String> colors = new ArrayList<String>();
        colors.add("Color " + count++);
        colors.add("Color " + count++);
        colors.add("Color " + count++);

        return colors;
    }

}
