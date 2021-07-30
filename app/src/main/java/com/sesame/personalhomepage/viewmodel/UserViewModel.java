package com.sesame.personalhomepage.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sesame.personalhomepage.MyApplication;
import com.sesame.personalhomepage.db.UserDao;
import com.sesame.personalhomepage.db.UserDatabase;
import com.sesame.personalhomepage.model.User;
import com.sesame.personalhomepage.repository.UserRepository;

import org.jetbrains.annotations.NotNull;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mUserRepository;
    private LiveData<User> mUser;
    private final String userId = "user-leaf";
//    private final String userName = "MichaelYe";

    public UserViewModel(@NonNull @NotNull Application application) {
        super(application);
        UserDatabase database = MyApplication.getUserDatabase();
        // UserDao用于访问数据库中的User表
        UserDao userDao = database.userDao();
        // 通过repository获取数据，不管repository是从数据库获取的还是从网络获取的。
        mUserRepository = new UserRepository(userDao, MyApplication.getApi());
        mUser = mUserRepository.getUser(userId);
    }

    public LiveData<User> getUser() {
        return mUser;
    }

    public void refresh() {
        mUserRepository.refresh(userId);
    }
}
