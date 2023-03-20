package com.swedbank.com.studentApplication.building.dao;

import com.swedbank.com.studentApplication.building.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
