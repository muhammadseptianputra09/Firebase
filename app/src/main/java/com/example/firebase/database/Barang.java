package com.example.firebase.database;

import java.io.Serializable;

public class Barang implements Serializable {
    private String kode;
    private String nama;


    public Barang() {
    }

    public String getKode() {
        return kode;
    }

    public void Barang(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public Barang(String nama) {
        this.nama = nama;
    }

    public Barang(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                '}';
    }
}
