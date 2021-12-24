package com.timesheet.persistence.repository;

import com.timesheet.persistence.entity.DiaFestivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaFestivoRepository extends JpaRepository<DiaFestivo,Long> {
}
