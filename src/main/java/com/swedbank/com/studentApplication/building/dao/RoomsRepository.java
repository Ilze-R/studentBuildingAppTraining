package com.swedbank.com.studentApplication.building.dao;

import com.swedbank.com.studentApplication.building.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<ClassRoom, Long> {
}
