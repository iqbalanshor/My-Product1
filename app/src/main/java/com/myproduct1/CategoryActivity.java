package com.myproduct1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CategoryActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private CardView cardLaptop, cardMouse, cardApparel, cardSneakers, cardBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_category);

        // Inisialisasi tombol kembali
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        // Inisialisasi card kategori
        cardLaptop = findViewById(R.id.card_laptop);
        cardMouse = findViewById(R.id.card_mouse);
        cardApparel = findViewById(R.id.card_apparel);
        cardSneakers = findViewById(R.id.card_sneakers);
        cardBag = findViewById(R.id.card_bag);

        // Set klik listener untuk setiap kategori
        cardLaptop.setOnClickListener(v -> showToast("Laptop"));
        cardMouse.setOnClickListener(v -> showToast("Mouse"));
        cardApparel.setOnClickListener(v -> showToast("Apparel"));
        cardSneakers.setOnClickListener(v -> showToast("Sneakers"));
        cardBag.setOnClickListener(v -> showToast("Bag"));

        // Jika kamu ingin menambahkan aksi klik menu/icon, gunakan ID berikut:
        ImageView ivLaptopMenu = findViewById(R.id.iv_laptop_menu);
        ivLaptopMenu.setOnClickListener(v -> showToast("Laptop Menu clicked"));
        // Lakukan hal yang sama untuk icon lainnya...
    }

    private void showToast(String message) {
        Toast.makeText(this, message + " clicked", Toast.LENGTH_SHORT).show();
    }
}


