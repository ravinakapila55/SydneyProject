package com.sydneyproject;

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
import com.sydneyproject.adapter.FaqAdapter;
import com.sydneyproject.home.HomePage;

public class FaqScreen  extends AppCompatActivity {

    RecyclerView recycler_faq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findIds();
    }

    RecyclerView recyclerYesterday;
    ImageView ivBack;
    TextView tvBack;

    public void findIds()
    {
        ivBack=(ImageView)findViewById(R.id.ivBack);
        tvBack=(TextView) findViewById(R.id.tvBack);

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(FaqScreen.this, HomePage.class);
                startActivity(intent);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(FaqScreen.this, HomePage.class);
                startActivity(intent);
            }
        });

        recycler_faq=(RecyclerView)findViewById(R.id.recycler_faq);

        recycler_faq.setLayoutManager(new LinearLayoutManager(this));

        setAdapter();
    }

    public void setAdapter()
    {
        FaqAdapter faqAdapter=new FaqAdapter(this);
        recycler_faq.setAdapter(faqAdapter);
    }

}
