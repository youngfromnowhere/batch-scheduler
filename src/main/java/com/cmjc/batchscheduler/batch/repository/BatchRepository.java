package com.cmjc.batchscheduler.batch.repository;

import com.cmjc.batchscheduler.batch.entity.Batch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    Optional<Batch> findById(Long id);
}
