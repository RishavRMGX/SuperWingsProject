package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.PeriodicTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicTableRepository extends JpaRepository<PeriodicTable, Long> {}
