package com.sydneyproject.notification;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sydneyproject.R;
import com.sydneyproject.adapter.NotificationAdapter;
import com.sydneyproject.home.HomePage;

public class NotificationList extends AppCompatActivity
{
    RecyclerView recyclerToday;
    RecyclerView recyclerYesterday;
    ImageView ivBack;
    TextView tvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notiification_list);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findIds();
    }

    public void findIds()
    {

        ivBack=(ImageView)findViewById(R.id.ivBack);
        tvBack=(TextView) findViewById(R.id.tvBack);

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(NotificationList.this, HomePage.class);
                startActivity(intent);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(NotificationList.this, HomePage.class);
                startActivity(intent);
            }
        });

        recyclerToday=(RecyclerView)findViewById(R.id.recyclerToday);
        recyclerYesterday=(RecyclerView)findViewById(R.id.recyclerYesterday);

        recyclerToday.setLayoutManager(new LinearLayoutManager(this));
        recyclerYesterday.setLayoutManager(new LinearLayoutManager(this));

        setAdapter();
    }

    public void setAdapter()
    {
        NotificationAdapter notificationAdapter=new NotificationAdapter(NotificationList.this);
        recyclerToday.setAdapter(notificationAdapter);
        recyclerYesterday.setAdapter(notificationAdapter);
    }
}
