package com.sesame.personalhomepage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sesame.personalhomepage.databinding.ActivityMainBinding;
import com.sesame.personalhomepage.model.User;
import com.sesame.personalhomepage.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel mUserViewModel;
    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        mUserViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    dataBinding.setUser(user);
                }
            }
        });
        mRefreshLayout = dataBinding.refreshLayout;

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mUserViewModel.refresh();
                mRefreshLayout.setRefreshing(false);
            }
        });
    }
}