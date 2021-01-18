package com.sydneyproject.otp;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sydneyproject.R;
import com.sydneyproject.plans.ChoosePlans;

public class VerifyMobileNumber  extends AppCompatActivity
{

    TextView tvSubmit;
    ImageView ivBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_number);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findIds();
    }

    public void findIds()
    {
        tvSubmit=(TextView)findViewById(R.id.tvSubmit);
        ivBack=(ImageView) findViewById(R.id.ivBack);

        tvSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showVerificationPopUp();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });
    }

    public void showVerificationPopUp()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.success_custom_popup, null);

        TextView tvOk=(TextView)dialogView.findViewById(R.id.tvOk);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        int width = WindowManager.LayoutParams.WRAP_CONTENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;

        tvOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                alertDialog.dismiss();
                Intent intent=new Intent(VerifyMobileNumber.this, ChoosePlans.class);
                startActivity(intent);
            }
        });

        alertDialog.show();
    }
}
