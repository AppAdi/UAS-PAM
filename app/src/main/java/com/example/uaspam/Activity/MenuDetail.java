package com.example.uaspam.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uaspam.R;

public class MenuDetail extends AppCompatActivity {
    private String xNama, xDetail, xPrice;
    private int xImage;
    private TextView etNama, etDetail, etPrice;
    private ImageView imgDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Intent terima = getIntent();
        xNama = terima.getStringExtra("xNama");
        xDetail = terima.getStringExtra("xDetail");
        xPrice = terima.getStringExtra("xPrice");
        xImage = terima.getIntExtra("xImage", -1);

        etNama = findViewById(R.id.tv_nama_detail);
        etDetail = findViewById(R.id.tv_detail_detail);
        etPrice = findViewById(R.id.tv_price_detail);
        imgDetail = findViewById(R.id.iv_image_detail);

        etNama.setText(xNama);
        etDetail.setText(xDetail);
        etPrice.setText(xPrice);
        imgDetail.setImageResource(xImage);
        imgDetail.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}