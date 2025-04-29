package com.myproduct1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private ImageView imgProduct;
    private TextView txtProductTitle, txtBrandValue, txtReleaseDateValue, txtColorValue, txtGenderValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details); // pastikan nama file XML-nya betul

        // Inisialisasi view
        btnBack = findViewById(R.id.btnBack);
        imgProduct = findViewById(R.id.imgProduct);
        txtProductTitle = findViewById(R.id.txtProductTitle);
        txtBrandValue = findViewById(R.id.txtBrandValue);
        txtReleaseDateValue = findViewById(R.id.txtReleaseDateValue);
        txtColorValue = findViewById(R.id.txtColorValue);
        txtGenderValue = findViewById(R.id.txtGenderValue);

        // Menambahkan fungsi tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke activity sebelumnya
            }
        });

        // (Opsional) Ambil data dari intent jika ingin menampilkan data dinamis
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            txtProductTitle.setText(extras.getString("title", "Product Title"));
            txtBrandValue.setText(extras.getString("brand", "Brand"));
            txtReleaseDateValue.setText(extras.getString("releaseDate", "Release Date"));
            txtColorValue.setText(extras.getString("color", "Color"));
            txtGenderValue.setText(extras.getString("gender", "Gender"));
            // Gambar bisa dimasukkan melalui Glide/Picasso jika diperlukan
        }
    }
}