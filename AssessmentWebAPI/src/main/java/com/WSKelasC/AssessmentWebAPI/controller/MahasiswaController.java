/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WSKelasC.AssessmentWebAPI.controller;

import com.WSKelasC.AssessmentWebAPI.exception.ResourceNotFoundException;
import com.WSKelasC.AssessmentWebAPI.model.Mahasiswa;
import com.WSKelasC.AssessmentWebAPI.repository.MahasiswaRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Acer
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/data")
public class MahasiswaController {
    
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    //get all mahasiswa
    @GetMapping("/mahasiswa")
    public List<Mahasiswa> getAllMahasiswa(){
        return mahasiswaRepository.findAll();
    }
    
    //membuat rest api mahasiswa
    @PostMapping("/mahasiswa")
    public Mahasiswa createMahasiswa(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaRepository.save(mahasiswa);
    }
    
    //get mahasiswa by id rest api
    @GetMapping("/mahasiswa/{id}")
    public ResponseEntity<Mahasiswa> getMahasiswaById(@PathVariable Long id){
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("mahasiswa not exist with id :" + id));
        return ResponseEntity.ok(mahasiswa);
    }
    
    //Update mahasiswa rest api
    @PutMapping("/mahasiswa/{id}")
    public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable Long id, @RequestBody Mahasiswa mahasiswaDetails){
        
         Mahasiswa mahasiswa = mahasiswaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("mahasiswa not exist with id :" + id));
         mahasiswa.setNim(mahasiswaDetails.getNim());
         mahasiswa.setNama(mahasiswaDetails.getNama());
         mahasiswa.setProdi(mahasiswaDetails.getProdi());
         mahasiswa.setFakultas(mahasiswaDetails.getFakultas());
         
         Mahasiswa updateMahasiswa= mahasiswaRepository.save(mahasiswa);
         return ResponseEntity.ok(updateMahasiswa);
        
    }
    
    //delete
    @DeleteMapping("/mahasiswa/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteMahasiswa(@PathVariable Long id){
         Mahasiswa mahasiswa = mahasiswaRepository.findById(id).
                 orElseThrow(() -> new ResourceNotFoundException
                ("mahasiswa not exist with id :" + id));
         
         mahasiswaRepository.delete(mahasiswa);
         Map<String, Boolean> response=new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
}