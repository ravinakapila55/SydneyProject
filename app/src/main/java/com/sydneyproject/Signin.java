package com.sydneyproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sydneyproject.otp.VerifyMobileNumber;
import com.sydneyproject.retrofit.RetrofitResponse;
import com.sydneyproject.retrofit.RetrofitService;
import com.sydneyproject.util.SharedPrefUtil;
import com.sydneyproject.util.URLHelper;
import org.json.JSONObject;

public class Signin extends AppCompatActivity implements RetrofitResponse
{
    TextView tvSignin;
    TextView tvRegister;
    EditText etEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }
        findIds();
    }

    public void findIds()
    {
        tvSignin=(TextView)findViewById(R.id.tvSignin);
        tvRegister=(TextView)findViewById(R.id.tvRegister);
        etEmail=(EditText) findViewById(R.id.etEmail);

        tvSignin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (checkValidations())
                {
                        callSignInService();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Signin.this,SignUp.class);
                startActivity(intent);
            }
        });

    }

    public void callSignInService()
    {
            try
            {
                JSONObject jsonObject=new JSONObject();
                /*email,mobile_number*/
                jsonObject.put("email",etEmail.getText().toString().trim());
                new RetrofitService(this, this, URLHelper.LOGIN ,
                        jsonObject,
                        700, 2,"1").callService(true);
                Log.e("LoginParams ",jsonObject.toString());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
    }

    public boolean checkValidations()
    {
        if (etEmail.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Please enter your email address or phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    SharedPrefUtil sharedPrefUtil;

    @Override
    public void onResponse(int RequestCode, String response)
    {
        switch (RequestCode)
        {
               case 700:
                try
                {
                    Log.e("LoginResponse ",response);
                    JSONObject jsonObject=new JSONObject(response);
                    Log.e("jsonObject ",jsonObject.toString());
                    if (jsonObject.getString("status").equalsIgnoreCase("true"))
                    {

                        Toast.makeText(this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(Signin.this,VerifyMobileNumber.class);
                        startActivity(intent);

//                        Alerts.callSweetAlertSuccessType(SignUp.this,Signin.class,"Register Successfully","Okay");
                    }
                    else
                    {
                        Toast.makeText(this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                break;
        }
    }
}
