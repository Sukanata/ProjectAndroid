package com.example.e_book;

public class menu {
    private String nama;
    private String harga;
    private String gambar;
    private String keterangan;

    public menu(String datanama, String dataharga, String datagambar, String dataketerangan){
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        keterangan = dataketerangan;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getKeterangan() {return keterangan;}
}