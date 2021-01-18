package com.sydneyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sydneyproject.R;


public class SavedBillAdapterNew extends RecyclerView.Adapter<SavedBillAdapterNew.MyViewHolder> {

    Context context;

    public SavedBillAdapterNew(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public SavedBillAdapterNew.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_saved_items_bill,parent,false);
        return new SavedBillAdapterNew.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedBillAdapterNew.MyViewHolder holder, int position)
    {


            if (position==0)
            {
                holder.tvName.setText("Paid");
                holder.tvItem.setText("Mark");
                holder.tvName.setTextColor(context.getResources().getColor(R.color.green));
            }
            else {
                holder.tvName.setText("Pending");
                holder.tvItem.setText("Anthony");
                holder.tvName.setTextColor(context.getResources().getColor(R.color.text_red));

            }

            holder.viewww.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvItem;
        TextView tvName;
        View viewww;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvItem=(TextView)itemView.findViewById(R.id.tvItem);
            tvName=(TextView)itemView.findViewById(R.id.tvName);
            viewww=(View) itemView.findViewById(R.id.viewww);
        }
    }
}

