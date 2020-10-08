package com.example.absenti.model;

public class ModelKelasMhs {
    private String idKls;
    private String namaKelas;

    public ModelKelasMhs(String idKls, String namaKelas) {
        this.idKls = idKls;
        this.namaKelas = namaKelas;
    }

    public String getIdKls() {
        return idKls;
    }

    public void setIdKls(String idKls) {
        this.idKls = idKls;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
