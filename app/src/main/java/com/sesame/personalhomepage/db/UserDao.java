package com.sesame.personalhomepage.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sesame.personalhomepage.model.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    // user是表名
    @Query("SELECT * FROM user WHERE login = :loginName")
    LiveData<User> getUserByLoginName(String loginName);
}
