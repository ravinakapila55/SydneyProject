package com.sydneyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sydneyproject.R;


public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.MyViewHolder>
{
    Context context;
    public FaqAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_faq,parent,false);
        return new FaqAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {

        holder.ivDrop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (holder.tvDesc.isShown())
                {
                    holder.ivDrop.setImageDrawable(context.getResources().getDrawable(R.drawable.drop_arrow));
                    holder.tvDesc.setVisibility(View.GONE);
                }
                else
                {
                    holder.tvDesc.setVisibility(View.VISIBLE);
                    holder.ivDrop.setImageDrawable(context.getResources().getDrawable(R.drawable.up_arrow));
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivDrop;
        TextView tvDesc;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivDrop=(ImageView)itemView.findViewById(R.id.ivDrop);
            tvDesc=(TextView) itemView.findViewById(R.id.tvDesc);
        }
    }
}
