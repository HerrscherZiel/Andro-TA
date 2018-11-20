package com.arne.tugasakhir;

import android.app.LauncherActivity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Fragment homeFragment;
    private CategoryFragment categoryFragment;
    private ProfileFragment profileFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        categoryFragment = new CategoryFragment();
        profileFragment = new ProfileFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_category :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(categoryFragment);
                        return true;

                    case R.id.nav_profile :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(profileFragment);
                        return true;

                    default:
                        return false;
                }
            }


        });

    }

        private void setFragment(Fragment fragment) {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, fragment);
            fragmentTransaction.commit();


    }
}
