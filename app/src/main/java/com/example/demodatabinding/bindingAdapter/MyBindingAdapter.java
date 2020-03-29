package com.example.demodatabinding.bindingAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demodatabinding.R;

public class MyBindingAdapter {
    /*
     * Use the flwg in xml-layout file
     * app:image_uri_adapter="@{product.image_uri}"
     * app:image_uri_error="@{@drawable/ic_launcher_background}"
     * app:image_uri_placeholder="@{@drawable/ic_launcher_background}"
     */
    @BindingAdapter({"image_uri_adapter", "image_uri_placeholder", "image_uri_error"})
    public static void loadImageUri(ImageView view, Uri uri, Drawable placeholder, Drawable error) {
        Context context =  view.getContext();
        Log.d("TAG", "loadImageUri: ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤ " + uri.toString());

        RequestOptions requestOptions = new RequestOptions().placeholder(placeholder).error(error);
        Glide.with(context).asBitmap().load(uri).apply( requestOptions).into(view);
    }

    /*
    * Use the flwg in xml-layout file
    * app:image_drawable_adapter="@{product.image_drawable}"
    * app:image_drawable_placeholder="@{@drawable/ic_launcher_background}"
    * app:image_drawable_error="@{@drawable/ic_launcher_background}"
    */
    @BindingAdapter({"image_drawable_adapter", "image_drawable_placeholder", "image_drawable_error"})
    public static void loadImageDrawable(ImageView view, int drawableId, Drawable placeholder, Drawable error) {
        Context context =  view.getContext();
        RequestOptions requestOptions = new RequestOptions().override(200, 200).placeholder(placeholder).error(error);
        Glide.with(context).asBitmap().load(drawableId).apply( requestOptions).into(view);
    }

}
