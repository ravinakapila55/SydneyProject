package com.sydneyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sydneyproject.R;

public class SavedBillsHomeAdapter extends RecyclerView.Adapter<SavedBillsHomeAdapter.MyViewHolder>
{

    Context context;

    public SavedBillsHomeAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.custo_save_bills_home,parent,false);
        return new SavedBillsHomeAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
