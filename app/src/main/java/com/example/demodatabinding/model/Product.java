package com.example.demodatabinding.model;

import android.net.Uri;

import java.text.DecimalFormat;

public class Product {

    private String id;
    private String title;
    private String description;
    private float rating;
    private float price;
    private float salePrice;
    private Uri image_uri;
    // just to demonistrate data binding with drawableImage
    private int image_drawable;
    private boolean isOnSale;

    public Product() {
    }

    public Product(String id, String title, String description, float rating, float price, float salePrice, Uri image_uri, int image_drawable) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.salePrice = salePrice;
        this.image_uri = image_uri;
        this.image_drawable = image_drawable;
        this.isOnSale = salePrice != 0.0 ? true : false;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public float getPrice() {
        return price;
    }


    public float getSalePrice() {
        return salePrice;
    }

    public Uri getImage_uri() {
        return image_uri;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public boolean isOnSale() {return isOnSale; }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public void setImage_uri(Uri image_uri) {
        this.image_uri = image_uri;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }

    public void setOnSale(boolean onSale) { isOnSale = onSale; }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", image_uri=" + image_uri +
                ", image_drawable=" + image_drawable +
                '}';
    }
}