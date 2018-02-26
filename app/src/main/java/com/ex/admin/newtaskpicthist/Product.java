package com.ex.admin.newtaskpicthist;

/**
 * Created by Admin on 24.02.2018.
 */

public class Product {
    String url;
    String time;
    String status;
    String id;


    Product(String url, String time, String status, String id) {
        this.time = time;
        this.url = url;
        this.id = id;
        this.status = status;
    }

    public Product() {
    }
}
