package com.example.dawiniapp;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SimpleRequestQueueFactory {

    private static SimpleRequestQueueFactory self = null;
    private static RequestQueue queue = null;
    private Context context = null;

    private SimpleRequestQueueFactory(Context context) {
        this.context = context;
        this.queue = Volley.newRequestQueue(this.context);
    }

    public static SimpleRequestQueueFactory getInstance(Context context) throws Exception{
        if (context == null){
            throw new Exception("context can not be null");
        }
        if (self == null){
            self = new SimpleRequestQueueFactory(context);
        }
        return self;
    }

    public RequestQueue getQueueInstance() {
        return this.queue;
    }
}
