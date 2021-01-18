package com.sydneyproject.payOptions;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sydneyproject.R;
import com.sydneyproject.home.HomePage;

public class ChoosePayOptions extends AppCompatActivity
{
    TextView tvDone;
    ConstraintLayout ccApple;
    ConstraintLayout ccGpay;
    ConstraintLayout ccSamsng;
    ConstraintLayout ccVenmo;
    ConstraintLayout ccZella;
    ConstraintLayout ccPaypal;
    RelativeLayout rlPayPalCheck;
    RelativeLayout rlZellaCheck;
    RelativeLayout rlVenCheck;
    RelativeLayout rlsamCheck;
    RelativeLayout rlgpCheck;
    RelativeLayout rlAlCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_pay_options);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findIds();
    }

    String selected="0";

    public void findIds()
    {
        tvDone=(TextView)findViewById(R.id.tvDone);
        ccApple=(ConstraintLayout) findViewById(R.id.ccApple);
        ccGpay=(ConstraintLayout) findViewById(R.id.ccGpay);
        ccSamsng=(ConstraintLayout) findViewById(R.id.ccSamsng);
        ccVenmo=(ConstraintLayout) findViewById(R.id.ccVenmo);
        ccZella=(ConstraintLayout) findViewById(R.id.ccZella);
        ccPaypal=(ConstraintLayout) findViewById(R.id.ccPaypal);
        rlPayPalCheck=(RelativeLayout) findViewById(R.id.rlPayPalCheck);
        rlZellaCheck=(RelativeLayout) findViewById(R.id.rlZellaCheck);
        rlVenCheck=(RelativeLayout) findViewById(R.id.rlVenCheck);
        rlsamCheck=(RelativeLayout) findViewById(R.id.rlsamCheck);
        rlgpCheck=(RelativeLayout) findViewById(R.id.rlgpCheck);
        rlAlCheck=(RelativeLayout) findViewById(R.id.rlAlCheck);

        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (selected.equalsIgnoreCase("0"))
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        tvDone.setBackground(getResources().getDrawable(R.drawable.transparent));
                    }

                    Toast.makeText(ChoosePayOptions.this, "Choose one payment option", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                    }

                    Intent intent=new Intent(ChoosePayOptions.this, HomePage.class);
                    startActivity(intent);
                }
            }
        });

        ccApple.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selected="1";
                rlAlCheck.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                }
            }
        });

        ccPaypal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selected="1";
                rlPayPalCheck.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                }

            }
        });

        ccVenmo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selected="1";

                rlVenCheck.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                }


            }
        });

        ccSamsng.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selected="1";

                rlsamCheck.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                }


            }
        });
        ccGpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                selected="1";

                rlgpCheck.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                }


            }
        });
        ccZella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                selected="1";

                rlZellaCheck.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tvDone.setBackground(getResources().getDrawable(R.drawable.gray_corner_box));
                }


            }
        });
    }
}
