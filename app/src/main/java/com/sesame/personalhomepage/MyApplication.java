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
        // [书P215]在此进行实例化比较好，方便统一管理和全局调用，也不用担心这两个的生命周期问题，因为通常是伴随整个APP的生命周期。
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
