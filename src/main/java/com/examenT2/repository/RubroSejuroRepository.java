package com.examenT2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.model.RubroSejuro;

@Repository
public interface RubroSejuroRepository extends JpaRepository<RubroSejuro, Integer>{

}
