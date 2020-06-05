package com.example.e_book;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class detail extends AppCompatActivity {
    public static final String keterangan="keterangan";
    public static final String gambardetail="NULL";
    public TextView tvnamadetail;
    public TextView tvketerangan;
    public ImageView imgambardetail;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.detail);

        tvketerangan = findViewById(R.id.tv_keterangan);
        imgambardetail = findViewById(R.id.imgambardetail);

        String simpanketerangan=getIntent().getStringExtra(keterangan);
        String simpangambar=getIntent().getStringExtra(gambardetail);

        tvketerangan.setText(simpanketerangan);
        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(imgambardetail);
    }
}
