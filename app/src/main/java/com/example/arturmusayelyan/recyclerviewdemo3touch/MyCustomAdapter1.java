package com.example.arturmusayelyan.recyclerviewdemo3touch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by artur.musayelyan on 06/11/2017.
 */

// chish gzevov sarqum enq interface ev nor heto imlements enq anum dranic
public class MyCustomAdapter1 extends RecyclerView.Adapter<MyCustomAdapter1.MyViewHolder> {
    Context context;
    List<SingleRow> dataList = Collections.emptyList();
    LayoutInflater inflater;

    ClickListener clickListener;

    public MyCustomAdapter1(Context context, List<SingleRow> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
        // this.clickListener = clickListener;
    }

    public void delete(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }


    // kam nuyune karanq konstructorov tanq
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row1, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.titleTextView.setText(dataList.get(position).getTitle());
        holder.flagImageView.setImageResource(dataList.get(position).getImageID());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        ImageView flagImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textView_forCustomAdapter1);
            flagImageView = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            clickListener.itemClicked(view,getAdapterPosition());
        }
    }
}
