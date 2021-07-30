package com.sesame.personalhomepage;

import android.app.Application;

import com.sesame.personalhomepage.api.Api;
import com.sesame.personalhomepage.api.RetrofitClient;
import com.sesame.personalhomepage.db.UserDatabase;

public class MyApplication extends Application {

    private static Api api;
    private static UserDatabase userDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        userDatabase = UserDatabase.getInstance(this);
        api = RetrofitClient.getInstance().getApi();
    }

    public static Api getApi() {
        return api;
    }

    public static UserDatabase getUserDatabase() {
        return userDatabase;
    }
}
