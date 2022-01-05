/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WSKelasC.AssessmentWebAPI.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "mahasiswa")

public class Mahasiswa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nim")
    private String nim;
    
    @Column(name="nama")
    private String nama;
    
    @Column(name="prodi")
    private String prodi;
    
    @Column(name="fakultas")
    private String fakultas;
    
    public Mahasiswa(){
        
    }

    public Mahasiswa(String nim, String nama, String prodi, String fakultas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    
    
}
