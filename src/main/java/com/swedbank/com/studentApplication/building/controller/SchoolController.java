package com.swedbank.com.studentApplication.building.controller;

import com.swedbank.com.studentApplication.building.model.Building;
import com.swedbank.com.studentApplication.building.model.ClassRoom;
import com.swedbank.com.studentApplication.building.service.SchoolService;
import com.swedbank.com.studentApplication.exceptions.StudentNotFoundException;
import com.swedbank.com.studentApplication.student.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j -> for errors
@Slf4j
@RestController
@RequestMapping("school")
//@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service){
        this.service = service;
    }

    @GetMapping("/buildings")
    public List<Building> allBuildings() {
        return service.allBuildings();
    }

    @GetMapping("/buildings/{buildingId}/rooms")
    public List<ClassRoom> getBuildingRooms(@PathVariable final int buildingId){
        return service.getBuildingRooms(buildingId);
    }

    @PutMapping("/rooms/{roomId}")
    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable long roomId, @RequestBody ClassRoom updatedRoom) {
        return service.updateClassroom(roomId, updatedRoom);
    }

}









