package com.example.arturmusayelyan.recyclerviewdemo3touch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by artur.musayelyan on 06/11/2017.
 */

public class MyCustomAdapter2 extends RecyclerView.Adapter<MyCustomAdapter2.MyViewHolder> {
    Context context;
    List<SingleRow> dataList = Collections.emptyList();
    LayoutInflater inflater;

    public MyCustomAdapter2(Context context, List<SingleRow> list) {
        this.context = context;
        this.dataList = list;
        inflater = LayoutInflater.from(context);
    }

    public void delete(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row1, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.titleTextView.setText(dataList.get(position).getTitle());
        holder.flageImageView.setImageResource(dataList.get(position).getImageID());

        //1-in tarberak
//        holder.flageImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Clicked at position " + position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    //3-rd tarberak
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        ImageView flageImageView;

        public MyViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.textView_forCustomAdapter1);
            flageImageView = view.findViewById(R.id.image_for_customadapter1);

            //2-rd tarberak
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context, "Clicked at position " + getPosition(), Toast.LENGTH_SHORT).show();
//                    delete(getAdapterPosition());
//                }
//            });

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked at position " + getPosition(), Toast.LENGTH_SHORT).show();
            delete(getAdapterPosition());
        }
    }
}
