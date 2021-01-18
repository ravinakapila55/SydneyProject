package com.sydneyproject.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sydneyproject.Drawer;
import com.sydneyproject.R;
import com.sydneyproject.bill.HomePageData;

public class HomePage extends Drawer implements View.OnClickListener
{
    ConstraintLayout ccSaved;
    ConstraintLayout ccBillYouOwe;
    ConstraintLayout ccTop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        tvheader.setText("Home");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findIds();
    }

    public void findIds()
    {
        ccSaved=(ConstraintLayout)findViewById(R.id.ccSaved);
        ccBillYouOwe=(ConstraintLayout)findViewById(R.id.ccBillYouOwe);
        ccTop=(ConstraintLayout)findViewById(R.id.ccTop);
        ccSaved.setOnClickListener(this);
        ccBillYouOwe.setOnClickListener(this);
        ccTop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ccSaved:
                Intent intent=new Intent(HomePage.this, HomePageData.class);
                startActivity(intent);
                break;

            case R.id.ccBillYouOwe:
                Intent intent11=new Intent(HomePage.this, HomePageData.class);
                startActivity(intent11);
                break;


            case R.id.ccTop:
                Intent intent21=new Intent(HomePage.this, HomePageData.class);
                startActivity(intent21);

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvProfile.setTextColor(getResources().getColor(R.color.dark_gray));
        tvHome.setTextColor(getResources().getColor(R.color.text_red));
        img_home.setImageDrawable(getResources().getDrawable(R.drawable.home_bottom));
        img_profile.setImageDrawable(getResources().getDrawable(R.drawable.profile_tab));
        tvSaved.setTextColor(getResources().getColor(R.color.dark_gray));
        img_saved.setImageDrawable(getResources().getDrawable(R.drawable.saved_bills_tab));
    }
}
