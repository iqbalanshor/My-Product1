package com.myproduct1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ListProdukActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private CardView cardPinkJordan, cardChicagoJordan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product); // pastikan nama file XML sesuai

        // Inisialisasi view
        btnBack = findViewById(R.id.btn_back);
        cardPinkJordan = findViewById(R.id.cardView_pink_jordan);
        cardChicagoJordan = findViewById(R.id.cardView_chicago_jordan);

        // Aksi tombol kembali
        btnBack.setOnClickListener(v -> finish());

        // Klik pada Pink Jordan
        cardPinkJordan.setOnClickListener(v -> {
            Intent intent = new Intent(ListProdukActivity.this, ProductDetailsActivity.class);
            intent intent = new Intent(ListProdukActivity.this, ProductDetailsActivity.class);
            intent.putExtra("title", "Women's Air Jordan 1 Mid 'PATENT VALENTINE'S DAY'");
            intent.putExtra("brand", "Air Jordan 1");
            intent.putExtra("releaseDate", "1 January 2025");
            intent.putExtra("color", "Pink");
            intent.putExtra("gender", "Women");
            startActivity(intent);
        });

        // Klik pada Chicago Jordan
        cardChicagoJordan.setOnClickListener(v -> {
            Intent intent = new Intent(ListProdukActivity.this, ProductDetailsActivity.class);
            intent.putExtra("title", "OFF-WHITE x Air Jordan 1 Retro High OG 'Chicago'");
            intent.putExtra("brand", "Air Jordan 1");
            intent.putExtra("releaseDate", "15 October 2024");
            intent.putExtra("color", "Red/White/Black");
            intent.putExtra("gender", "Unisex");
            startActivity(intent);
        });
    }
}