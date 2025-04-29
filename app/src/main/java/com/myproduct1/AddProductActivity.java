package com.myproduct1;

import android.app.DatePickerDialog; import android.os.Bundle; import android.view.View; import android.widget.ArrayAdapter; import android.widget.Button; import android.widget.DatePicker; import android.widget.EditText; import android.widget.ImageButton; import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity; import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat; import java.util.ArrayList; import java.util.Calendar; import java.util.Date; import java.util.List; import java.util.Locale;

public class AddProductActivity extends AppCompatActivity {

    private EditText etProductName, etProductNote, etDate;
    private ConstraintLayout layoutCategoryDropdown, layoutColorPicker;
    private Button btnSaveProduct;
    private ImageButton btnClose;
    private View colorCircle;
    private Calendar calendar;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);

        // Initialize views
        etProductName = findViewById(R.id.et_product_name);
        etProductNote = findViewById(R.id.et_product_note);
        etDate = findViewById(R.id.et_date);
        layoutCategoryDropdown = findViewById(R.id.layout_category_dropdown);
        layoutColorPicker = findViewById(R.id.layout_color_picker);
        btnSaveProduct = findViewById(R.id.btn_save_product);
        btnClose = findViewById(R.id.btn_close);
        colorCircle = findViewById(R.id.color_circle);

        // Initialize date picker
        calendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        // Set up click listeners
        setupClickListeners();
    }

    private void setupClickListeners() {
        // Close button
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Date picker
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Category dropdown
        layoutCategoryDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryDropdown();
            }
        });

        // Color picker
        layoutColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPicker();
            }
        });

        // Save button
        btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDateDisplay();
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void updateDateDisplay() {
        etDate.setText(dateFormatter.format(calendar.getTime()));
    }

    private void showCategoryDropdown() {
        // Example implementation - you would replace this with your own category data
        final List<String> categories = new ArrayList<>();
        categories.add("Laptop");
        categories.add("Mouse");
        categories.add("Apparel");
        categories.add("Snakers");
        categories.add("Bag");

        // Create and show dialog with categories
        // This is a simplified example - you might want to use a custom dialog or spinner
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Select Category");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, categories);

        builder.setAdapter(adapter, (dialog, which) -> {
            // Update the category field with selected category
            // You would need to add a TextView to display the selected category
            Toast.makeText(AddProductActivity.this,
                    "Selected: " + categories.get(which), Toast.LENGTH_SHORT).show();
        });

        builder.show();
    }

    private void showColorPicker() {
        // Example implementation - you would implement a color picker here
        // This could be a custom dialog or a library color picker
        final int[] colors = {
                getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_purple)
        };

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Select Color");

        // Simple color selection dialog
        // In a real app, you would use a proper color picker library
        builder.setItems(new String[]{"Red", "Blue", "Green", "Orange", "Purple"}, (dialog, which) -> {
            // Update the color circle with selected color
            colorCircle.setBackgroundColor(colors[which]);
        });

        builder.show();
    }

    private void saveProduct() {
        // Validate input fields
        String productName = etProductName.getText().toString().trim();
        String productNote = etProductNote.getText().toString().trim();
        String date = etDate.getText().toString().trim();

        if (productName.isEmpty()) {
            etProductName.setError("Product name is required");
            return;
        }

        // Save product data (this would connect to your database in a real app)
        // For this example, we'll just show a success message
        Toast.makeText(this, "Product saved successfully", Toast.LENGTH_SHORT).show();

        // Close activity
        finish();
    }
}