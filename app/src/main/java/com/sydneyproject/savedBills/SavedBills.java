package com.sydneyproject.savedBills;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sydneyproject.Drawer;
import com.sydneyproject.R;
import com.sydneyproject.adapter.SavedBillAdapter;

public class SavedBills extends Drawer implements View.OnClickListener {


    RecyclerView recyclerBill;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_bill_listing);
        tvheader.setText("Saved Bills");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        findInit();
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        tvSaved.setTextColor(getResources().getColor(R.color.text_red));
        tvHome.setTextColor(getResources().getColor(R.color.dark_gray));
        tvHome.setTextColor(getResources().getColor(R.color.dark_gray));
        img_home.setImageDrawable(getResources().getDrawable(R.drawable.home_gray));
        img_profile.setImageDrawable(getResources().getDrawable(R.drawable.profile_tab));
        img_saved.setImageDrawable(getResources().getDrawable(R.drawable.saved_bill_orange));
    }

    public void findInit()
    {
        recyclerBill=(RecyclerView)findViewById(R.id.recyclerBill);

        recyclerBill.setLayoutManager(new LinearLayoutManager(SavedBills.this));



        setAdapter();
    }


    public void setAdapter()
    {
        SavedBillAdapter billAdapter=new SavedBillAdapter(this);
        recyclerBill.setAdapter(billAdapter);

        billAdapter.onItemSelectedListener(new SavedBillAdapter.onClickListener()
        {
            @Override
            public void onItemClick(int layoutPosition, View view) {
                Intent intent=new Intent(SavedBills.this,SavedBillDetails.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v)
    {

    }
}
