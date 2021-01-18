package com.sydneyproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sydneyproject.retrofit.RetrofitResponse;
import com.sydneyproject.retrofit.RetrofitService;
import com.sydneyproject.util.CommonMethod;
import com.sydneyproject.util.SharedPrefUtil;
import com.sydneyproject.util.URLHelper;
import org.json.JSONObject;
import de.hdodenhof.circleimageview.CircleImageView;


public class SignUp extends AppCompatActivity implements RetrofitResponse
{

    TextView tvSignin;
    TextView tvSignUp;
    EditText etUname,etEmail,etMob;
    CircleImageView ivProfile;
    ImageView ivCamera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        sharedPrefUtil=new SharedPrefUtil(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findIds();
    }



    private Activity mActivity;








    public void findIds()
    {
        tvSignin=(TextView)findViewById(R.id.tvSignin);
        tvSignUp=(TextView)findViewById(R.id.tvSignUp);
        etUname=(EditText) findViewById(R.id.etUname);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etMob=(EditText) findViewById(R.id.etMob);
        ivProfile=(CircleImageView) findViewById(R.id.ivProfile);
        ivCamera=(ImageView) findViewById(R.id.ivCamera);

        tvSignin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SignUp.this,Signin.class);
                startActivity(intent);
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (checkValidations())
                {
                    callSignUpService();
                }
            }
        });

        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void callSignUpService()
    {
        try
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("username",etUname.getText().toString().trim());
            jsonObject.put("email",etEmail.getText().toString().trim());
            jsonObject.put("mobile_number",etMob.getText().toString().trim());

            Log.e("SignupParams ",jsonObject.toString());
            new RetrofitService(this, this, URLHelper.REGISTER ,
                    jsonObject,
                    500, 2,"1").callService(true);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public boolean checkValidations()
    {
        if (etUname.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Please enter your user name", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (etUname.getText().toString().trim().length()<3)
        {
            Toast.makeText(this, "Username atleast 3 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (etEmail.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!CommonMethod.isValidEmail(etEmail.getText().toString().trim())) {
            Toast.makeText(this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (etMob.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Please enter your mobile number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (etMob.getText().toString().trim().length()<10)
        {
            Toast.makeText(this, "Mobile number must be atleast 10 digits", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }



    SharedPrefUtil sharedPrefUtil;
    @Override
    public void onResponse(int RequestCode, String response) {

        switch (RequestCode)
        {
            case 500:
                try {
                    Log.e("SignupResponse ",response);
                    JSONObject jsonObject=new JSONObject(response);
                    Log.e("jsonObject ",jsonObject.toString());

                    if (jsonObject.getString("status").equalsIgnoreCase("true"))
                    {
                        JSONObject data=jsonObject.getJSONObject("data");

                        sharedPrefUtil.saveString(SharedPrefUtil.USER_ID,data.getString("id"));
                        sharedPrefUtil.saveString(SharedPrefUtil.NAME,data.getString("username"));
                        sharedPrefUtil.saveString(SharedPrefUtil.EMAIL,data.getString("email"));
                        sharedPrefUtil.saveString(SharedPrefUtil.PHONE_NUMBER,data.getString("mobile_number"));

                        Toast.makeText(this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(SignUp.this,Signin.class);
                        startActivity(intent);

//                        Alerts.callSweetAlertSuccessType(SignUp.this,Signin.class,"Register Successfully","Okay");
                    }
                    else {
                        Toast.makeText(this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                break;
        }

    }
}
