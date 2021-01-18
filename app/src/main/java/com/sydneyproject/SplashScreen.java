package com.sydneyproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sydneyproject.welcome.WelcomeScreen;

public class SplashScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        callNextAction();
    }

    public void callNextAction()
    {
        Handler handler=new Handler();
        Runnable runnable=new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent=new Intent(SplashScreen.this, WelcomeScreen.class);
                startActivity(intent);
            }
        };
        handler.postDelayed(runnable,4000);
    }
}
