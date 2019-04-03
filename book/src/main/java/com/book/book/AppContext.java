package com.book.book;

import android.content.Context;

import com.book.book.util.PageFactory;

import org.litepal.LitePalApplication;


public class AppContext extends LitePalApplication {
    public static volatile Context applicationContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        LitePalApplication.initialize(this);
        Config.createConfig(this);
        PageFactory.createPageFactory(this);
    }

}
