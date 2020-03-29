package com.example.demodatabinding.model;

import java.text.DecimalFormat;

public class Util {
    public static String getFormatedPrice(float value) {
        return String.valueOf(new DecimalFormat("###,###,###.00").format(value));
    }

    public static String getFormatedQuantity(int value) {
        return "Qty: " + String.valueOf(value);
    }


}
