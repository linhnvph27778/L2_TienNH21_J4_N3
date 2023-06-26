package com.example.datn.repository;

import com.example.datn.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SizeRepo extends JpaRepository<Size, UUID> {
}
