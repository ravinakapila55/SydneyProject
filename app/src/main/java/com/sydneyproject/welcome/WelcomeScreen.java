package com.sydneyproject.welcome;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.sydneyproject.R;
import com.sydneyproject.Signin;
import com.sydneyproject.adapter.WelcomeScreenAdapter;
import com.sydneyproject.model.SliderModel;
import com.viewpagerindicator.LinePageIndicator;
import java.util.ArrayList;

public class WelcomeScreen extends AppCompatActivity
{

    ArrayList<SliderModel> list=new ArrayList<>();
    ViewPager viewpager;

    int tab;
    TextView btn_next;

    WelcomeScreenAdapter welcomeScreenAdapter;

    LinePageIndicator indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screens);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        viewpager=(ViewPager)findViewById(R.id.viewpager);
        btn_next=(TextView) findViewById(R.id.btn_next);
        indicator=(LinePageIndicator) findViewById(R.id.indicator);
        tab = viewpager.getCurrentItem();

        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.e("CountNext ",count+"");
                if (btn_next.getText().toString().equalsIgnoreCase("GET STARTED"))
                {
                    Intent intent=new Intent(WelcomeScreen.this, Signin.class);
                    startActivity(intent);
                }
                else
                {
                    viewpager.arrowScroll(View.FOCUS_RIGHT);
                    count=count+1;
                }
            }
        });
        setadapter();
    }

    int count=0;
    public void setData()
    {
        list.clear();

        SliderModel sliderModel = new SliderModel("0", "Lorem","Lorem ipsum dolor sit amet, consectetur adipiscing elit.Donec eget porta dui, eget tempor eros. Etiam blandit pharetra egestas. Proin varius egestas quam, faucibus elementum felis cursus a. Proin quis velit purus. Vivamus feugiat ante nec odio vehicula, molestie vestibulum dolor auctor");
        list.add(sliderModel);

        sliderModel = new SliderModel("1", "Welcome","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget porta dui, eget tempor eros. Etiam blandit pharetra egestas. Proin varius egestas quam, faucibus elementum felis cursus a. Proin quis velit purus. Vivamus feugiat ante nec odio vehicula, molestie vestibulum dolor auctor");
        list.add(sliderModel);
    }

    private void setadapter()
    {
        setData();

        welcomeScreenAdapter = new WelcomeScreenAdapter(this, list);
        viewpager.setAdapter(welcomeScreenAdapter);
        indicator.setViewPager(viewpager);


        final float density = getResources().getDisplayMetrics().density;
        indicator.setSelectedColor(0x88FF0000);
        indicator.setUnselectedColor(0xFF888888);
        indicator.setStrokeWidth(4 * density);
        indicator.setLineWidth(30 * density);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                Log.e("PositionViewPager ",positionOffset+"");
                Log.e("position ",position+"");
            }

            @Override
            public void onPageSelected(int position)
            {
                Log.e("countScroll ",count+"");
                Log.e("positionScroll ",position+"");
                Log.e("listSize ",list.size()+"");

                if (position==list.size()-1)
                {
                    btn_next.setText("GET STARTED");
                }
                else
                {
                    btn_next.setText("NEXT");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

    }

}
