package com.sydneyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sydneyproject.R;

public class SavedBillAdapter extends RecyclerView.Adapter<SavedBillAdapter.MyViewHolder> {

    Context context;

    public SavedBillAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_saved,parent,false);
        return new SavedBillAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    onClickListener.onItemClick(getAdapterPosition(),v);
                }
            });
        }
    }


    public void onItemSelectedListener(onClickListener onClickListener)
    {
        this.onClickListener=onClickListener;
    }

    onClickListener onClickListener;
    public interface onClickListener
    {
        public void onItemClick(int layoutPosition,View view);
    }


}
