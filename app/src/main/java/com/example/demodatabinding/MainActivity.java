package com.example.demodatabinding;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.example.demodatabinding.databinding.ActivityMainBinding;
import com.example.demodatabinding.model.Product;
import com.example.demodatabinding.model.Repo;
import com.example.demodatabinding.model.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*
    *   project:
    *   1- make sure that AndroidSDK -> SDK tools -> support repository -> Android support repository is installed.
    *   2- app/gradle : Android.dataBinding.enabled = true.
    *
    *   in the xml file
    *   1- add <layout></layout> tells androidStudio that we'll use dataBinding with this view
    *   2- <data></data> inside "<layout>":
            we can declare variables which will be bound to here,, use "snake_case" with variable's naming
    *   3- To use any other classes inside the scriplet @{ .. },  we can import it using import-tag
    *        <import type="android.view.View"/> inside "<layout>"
    *        and inside the scriplet
    *        android:visibility="@{product.isOnSale ? View.VISIBLE : View.INVISIBLE}"
    *
    *   Activity
    *   1- after adding layout-tag in the xml file, a "binding class" with the same xml file name will be generated but with "PascalCase"
    *      naming, we have to use an instance of the generated binding class in order to bind to the view.
    *      if the xml file is "activity_main.xml" the generated class will be "ActivityMainBinding.java".
    *   2- init mainBinding = DataBindingUtil.setContentView(..)
    *   3- in the activiey bind the value of variable in the xml_layout to the model           mainBinding.setProduct(product);
    *
    * to Access any variable declared in the xml file use the same variable name but in "PascalCase"
    *       for ex. if "var_name" is declared in the xml, we can bind it with a variable in Activity with the name "VarName"



    * */
    private static final String TAG = "MainActivity";
    ActivityMainBinding mainBinding;
    private Product product;
//    private int Quantity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap<String  , Product> products = Repo.getData();
        product = products.get("1");


        initView();



        int random =  new Random().nextInt(10);
        float rating = (float)((random/10.0) +  3.0);

    }

    private void initView(){
//        we don't need to use setContentView(..) ,, instead initiate the instance of the generated "binding class"
//        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        mainBinding.setProduct(product);
        mainBinding.setQuantity(1);
        mainBinding.setMainActiviy(this);



//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    /**/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // this will be used inside an experssion in activity_main.xml => view by id @+id/quantity_button => onClick listner
    public void inflateQuantitlyDialog(){
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager() , "Choose Quantity");
    }

    public void setQuantity(int value){
        mainBinding.setQuantity(value);
    }


}
