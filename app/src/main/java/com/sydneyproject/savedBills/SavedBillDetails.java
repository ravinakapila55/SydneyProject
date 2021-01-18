package com.sydneyproject.savedBills;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sydneyproject.R;
import com.sydneyproject.adapter.SavedBillAdapterNew;

public class SavedBillDetails extends AppCompatActivity
{

    RecyclerView recycler;
    RecyclerView recyclerBill;
    ImageView ivBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_bill_details);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setBackgroundDrawableResource(R.drawable.white_background);
        }

        init();
    }

    public void init()
    {
        recycler=(RecyclerView)findViewById(R.id.recycler);
        recyclerBill=(RecyclerView)findViewById(R.id.recyclerBill);
        ivBack=(ImageView) findViewById(R.id.ivBack);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recyclerBill.setLayoutManager(new LinearLayoutManager(this));

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        setItemsAdapter();
        setBillAdapter();
    }

    public void setItemsAdapter()
    {
        SavedItemsAdapter  savedItemsAdapter=new SavedItemsAdapter(this);
        recycler.setAdapter(savedItemsAdapter);
    }

    public void setBillAdapter()
    {
        SavedBillAdapterNew savedItemsAdapter=new SavedBillAdapterNew(this);
        recyclerBill.setAdapter(savedItemsAdapter);
    }
}
