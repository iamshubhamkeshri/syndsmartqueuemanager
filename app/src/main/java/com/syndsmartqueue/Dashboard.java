package com.syndsmartqueue;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    public final static String MESSAGE_KEY ="message_key";
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_feed:
                    fragment = new BankFeedFragment();
                    break;

                case R.id.navigation_qrscan:
                    fragment = new QrScanFragment();
                    break;

                case R.id.navigation_analytics:
                    fragment = new BranchFreePredictFragment();
                    break;

                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    break;
            }

            return loadFragment(fragment);
        }

    };
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_KEY);
        if(message == "Skip"){
            loadFragment(new HomeFragment());
            navigation.setSelectedItemId(R.id.navigation_home);
        }else{
            loadFragment(new QrScanFragment());
            navigation.setSelectedItemId(R.id.navigation_qrscan);
        }

    }

}
