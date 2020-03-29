package com.example.demodatabinding.model;


import android.content.ContentResolver;
import android.net.Uri;

import com.example.demodatabinding.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Repo {

    public static HashMap<String, Product> getData() {
        ArrayList<Integer> imgIds = new ArrayList<>();

        for (Field felt : R.drawable.class.getFields())
            try {
                if (felt.getName().matches("^img+\\S*$")) {
                    imgIds.add(felt.getInt(null));
                    //Log.i("LOG_TAG", "------------***********-----------" + field.getName() + " ##### " + field.getInt(null))
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        HashMap<String, Product> data = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            String id = i + "";
            String title = "Product title " + i;
            String desc = "Description of " + i + "...";
            Random random = new Random();
            float rating = (float) ((random.nextInt(10) / 10.0) + (i % 2 == 0 ? 3.0 : 4.0));
            float price =(float) ( random.nextInt(100) + 100 + (Math.round(rating*20) / 10.0));
            float salePrice =(float) (i % 2 == 0 ? 0.0 : price/2);

            Uri image_uri = Uri.parse("android.resource://com.example.demodatabinding/drawable/img_" + i % 5 ); // Notice without the file extention ".png"

            int image_drawable = imgIds.get(i % 5);
            Product p = new Product(id, title, desc, rating, price, salePrice, image_uri, image_drawable);

            data.put(id, p);
        }

        return data;
    }
}


