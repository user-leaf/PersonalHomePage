package com.sesame.personalhomepage.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.sesame.personalhomepage.api.Api;
import com.sesame.personalhomepage.db.UserDao;
import com.sesame.personalhomepage.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserDao mUserDao;
    private Api mApi;

    public UserRepository(UserDao userDao, Api api) {
        mUserDao = userDao;
        mApi = api;
    }

    public LiveData<User> getUser(String name) {
        refresh(name);
        return mUserDao.getUserByLoginName(name);
    }

    public void refresh(String userName) {
        mApi.getUser(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null) {
                    insertUser(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void insertUser(User user) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (user != null) {
                    mUserDao.insertUser(user);
                }
            }
        });
    }
}
