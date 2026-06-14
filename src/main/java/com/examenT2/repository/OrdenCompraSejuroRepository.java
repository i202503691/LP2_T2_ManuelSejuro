package com.examenT2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.model.OrdenCompraSejuro;

@Repository
public interface OrdenCompraSejuroRepository extends JpaRepository<OrdenCompraSejuro, Integer> {

	List<OrdenCompraSejuro> findAllByOrderByNroOrdenDesc();
}
