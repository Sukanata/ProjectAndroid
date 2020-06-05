package com.example.e_book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private ArrayList<menu>menus;
    private Button btn;

    public MenuAdapter(Context mcontext, ArrayList<menu> menubuku){
        context=mcontext;
        menus=menubuku;

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent, false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        menu menubaru=menus.get(position);
        String gambarbaru=menubaru.getGambar();
        String harga=menubaru.getHarga();
        String nama=menubaru.getNama();

        holder.tvnamadata.setText(nama);
        holder.tvhargadata.setText(harga);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.imdata);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        public ImageView imdata;
        public TextView tvhargadata;
        public TextView tvnamadata;
        public TextView tvketerangan;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
           imdata= itemView.findViewById(R.id.img_menu);
           tvhargadata= itemView.findViewById(R.id.tv_harga);
           tvnamadata= itemView.findViewById(R.id.tv_nama);
           tvketerangan= itemView.findViewById(R.id.tv_keterangan);

            btn = itemView.findViewById(R.id.btn_detail );
            btn.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent = new Intent(context, detail.class);
                    intent.putExtra(detail.keterangan, menus.get(getAdapterPosition()).getKeterangan());
                    intent.putExtra(detail.gambardetail, menus.get(getAdapterPosition()).getGambar());
                    context.startActivity(intent);
                }
            } );

        }
    }
}
