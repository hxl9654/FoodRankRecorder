package com.hxlxz.hxl.foodrankrecorder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new FragmentHome());
                    return true;
                case R.id.navigation_add:
                    replaceFragment(new FragmentAdd());
                    return true;
                case R.id.navigation_setting:
                    replaceFragment(new FragmentSetting());
                    return true;
            }
            return false;
        }

    };
    BottomNavigationView navigation;

    @Override
    public void onBackPressed() {
        switch (((FrameLayout) findViewById(R.id.content)).getChildAt(0).getId()){
            case R.id.FragmentAdd:
            case R.id.FragmentSetting:
                //replaceFragment(new FragmentHome());
                navigation.setSelectedItemId(R.id.navigation_home);
                break;
            case R.id.FragmentLogin:
            case R.id.FragmentFriend:
                replaceFragment(new FragmentSetting());
                break;
            case R.id.FragmentRegister:
            case R.id.FragmentResetPassword:
                replaceFragment(new FragmentLogin());
                break;
            case R.id.FragmentShop:
            case R.id.FragmentFood:
                replaceFragment(new FragmentAdd());
                break;
            case R.id.FragmentHome:
                super.onBackPressed();
                break;
            default:
                throw new UnsupportedOperationException("碎片ID未在onBackPressed内列出。");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        replaceFragment(new FragmentHome());
        navigation.setSelectedItemId(R.id.navigation_home);
    }
}
