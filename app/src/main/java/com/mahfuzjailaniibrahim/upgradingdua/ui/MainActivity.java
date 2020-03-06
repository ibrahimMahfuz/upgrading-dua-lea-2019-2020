package com.mahfuzjailaniibrahim.upgradingdua.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.mahfuzjailaniibrahim.upgradingdua.R;
import com.mahfuzjailaniibrahim.upgradingdua.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, HomeFragment.newInstance(),HomeFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
