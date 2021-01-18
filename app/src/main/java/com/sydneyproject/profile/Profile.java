package com.sydneyproject.profile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sydneyproject.Drawer;
import com.sydneyproject.R;
import com.sydneyproject.home.HomePage;
import com.sydneyproject.savedBills.SavedBillDetails;
import com.sydneyproject.savedBills.SavedBills;

public class Profile extends AppCompatActivity {

    ImageView ivBack;
    TextView tvBack;
    ConstraintLayout ccHome;
    RelativeLayout rl_saved;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        ivBack=(ImageView)findViewById(R.id.ivBack);
        tvBack=(TextView) findViewById(R.id.tvBack);
        ccHome=(ConstraintLayout) findViewById(R.id.ccHome);
        rl_saved=(RelativeLayout) findViewById(R.id.rl_saved);

        ccHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Profile.this, HomePage.class);
                startActivity(intent);
            }
        });


        rl_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Profile.this, SavedBills.class);
                startActivity(intent);
            }
        });


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Profile.this, HomePage.class);
                startActivity(intent);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Profile.this, HomePage.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
