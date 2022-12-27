package com.example.uaspam.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uaspam.Model.DataModel;
import com.example.uaspam.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private ArrayList<DataModel> listData;

    public AdapterData(Context ctx, ArrayList<DataModel> listData){
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public AdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderData holder, int position) {
//        DataModel dm = listData.get(position);

        holder.tvId.setText(String.valueOf(listData.getId()));
        holder.tvNama.setText(dm.getFoodName());
        holder.tvDetail.setText(dm.getDetails());
        holder.tvPrice.setText(dm.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDetailActivity(listData.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvDetail, tvPrice;
        CardView carditem;

        public HolderData(@NonNull View itemView){
            super(itemView);

            tvId= itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }

    }
}
