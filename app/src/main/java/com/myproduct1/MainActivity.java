package com.myproduct1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private ProductAdapter adapter;
    private List<Product> productList;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Inisialisasi View
        rvProducts = findViewById(R.id.rvProducts);
        etSearch   = findViewById(R.id.etSearch);

        // 2. Setup RecyclerView
        rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        productList = new ArrayList<>();
        // Tambahkan data produk
        productList.add(new Product("Macbook Air 2022", "Apple", R.drawable.macbook));
        productList.add(new Product("Women's Air Jordan 1", "Air Jordan", R.drawable.sneaker));
        productList.add(new Product("Fear Of God Hoodie", "Fear Of God", R.drawable.hoodie));
        productList.add(new Product("LVXN8 Backpack", "Louis Vuitton", R.drawable.backpack));

        adapter = new ProductAdapter(productList);
        rvProducts.setAdapter(adapter);

        // 3. Pasang listener untuk filter search
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void afterTextChanged(Editable s) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }
        });

        // 4. Set up the "+" icon listener
        ImageView ivAddCategory = findViewById(R.id.fabAdd);
        ivAddCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivity(intent);
        });
    }
}
