package com.sydneyproject.bill;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sydneyproject.Drawer;
import com.sydneyproject.R;
import com.sydneyproject.adapter.SavedBillsHomeAdapter;
import com.sydneyproject.adapter.TopFriendsAdapter;
import com.sydneyproject.savedBills.SavedBills;

public class HomePageData extends Drawer {

    RecyclerView recyclerSaved,recyclerbills,recycleFriends;
    TextView tvAddBill,tvAddPlus;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
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
        recyclerSaved=(RecyclerView)findViewById(R.id.recyclerSaved);
        recyclerbills=(RecyclerView)findViewById(R.id.recyclerbills);
        recycleFriends=(RecyclerView)findViewById(R.id.recycleFriends);
        tvAddBill=(TextView) findViewById(R.id.tvAddBill);
        tvAddPlus=(TextView) findViewById(R.id.tvAddPlus);

        tvAddBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePageData.this, SavedBills.class);
                startActivity(intent);
            }
        });

        tvAddPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(HomePageData.this,SavedBills.class);
                startActivity(intent);
            }
        });

        recyclerSaved.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerbills.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        setAdapter();
    }

    public void setAdapter()
    {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recycleFriends.setLayoutManager(layoutManager);

        SavedBillsHomeAdapter savedBillsHomeAdapter=new SavedBillsHomeAdapter(this);
        recyclerSaved.setAdapter(savedBillsHomeAdapter);
        recyclerbills.setAdapter(savedBillsHomeAdapter);

        TopFriendsAdapter topFriendsAdapter=new TopFriendsAdapter(this);
        recycleFriends.setAdapter(topFriendsAdapter);
    }

}

