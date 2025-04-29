package com.myproduct1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;      // data asli
    private final List<Product> filteredList;     // data hasil filter

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
        this.filteredList = new ArrayList<>(productList);
    }

    @NonNull @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product p = filteredList.get(position);
        holder.tvName.setText(p.getName());
        holder.tvBrand.setText(p.getBrand());
        holder.ivProduct.setImageResource(p.getImageResId());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    /** Method untuk filter list berdasarkan keyword */
    public void filter(String text) {
        filteredList.clear();
        if (text.isEmpty()) {
            filteredList.addAll(productList);
        } else {
            String lower = text.toLowerCase();
            for (Product p : productList) {
                if (p.getName().toLowerCase().contains(lower) ||
                        p.getBrand().toLowerCase().contains(lower)) {
                    filteredList.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView tvName, tvBrand;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvName    = itemView.findViewById(R.id.tvProductName);
            tvBrand   = itemView.findViewById(R.id.tvProductBrand);
        }
    }
}
