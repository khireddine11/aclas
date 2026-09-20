package com.example.aclas.adapter;

import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aclas.R;
import com.example.aclas.model.Aclas;
import java.util.ArrayList;
import java.util.List;

public class AlcasAdapter extends RecyclerView.Adapter<AlcasAdapter.AlcasViewHolder> {

    private List<Aclas> items = new ArrayList<>();

    public void setItems(List<Aclas> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlcasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alcas, parent, false);
        return new AlcasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlcasViewHolder holder, int position) {
        Aclas item = items.get(position);
        holder.tvWeight.setText(item.getFormattedWeight());
        holder.tvPrice.setText(String.valueOf(item.getMainprice()));
        holder.tvStatus.setText("Acceptable Margin");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class AlcasViewHolder extends RecyclerView.ViewHolder {
        TextView tvWeight, tvPrice, tvStatus;

        public AlcasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
