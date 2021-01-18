package com.sydneyproject.plans;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sydneyproject.R;
import com.sydneyproject.payOptions.ChoosePayOptions;

public class ChoosePlans extends AppCompatActivity
{

    ConstraintLayout ccStandard,ccProfessional,ccFree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_plan);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }
        findIds();
    }

    public void findIds()
    {
        ccStandard=(ConstraintLayout)findViewById(R.id.ccStandard);
        ccProfessional=(ConstraintLayout)findViewById(R.id.ccProfessional);
        ccFree=(ConstraintLayout)findViewById(R.id.ccFree);

        ccStandard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(ChoosePlans.this,ChoosePayOptions.class);
                startActivity(intent);
            }
        });

        ccFree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(ChoosePlans.this,ChoosePayOptions.class);
                startActivity(intent);
            }
        });

        ccProfessional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(ChoosePlans.this,ChoosePayOptions.class);
                startActivity(intent);
            }
        });
    }
}
