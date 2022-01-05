/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.WSKelasC.AssessmentWebAPI.repository;

import com.WSKelasC.AssessmentWebAPI.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long>{
    
}
