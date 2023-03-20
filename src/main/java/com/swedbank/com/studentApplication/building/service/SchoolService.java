package com.swedbank.com.studentApplication.building.service;

import com.swedbank.com.studentApplication.building.dao.BuildingRepository;
import com.swedbank.com.studentApplication.building.dao.RoomsRepository;
import com.swedbank.com.studentApplication.building.model.Building;
import com.swedbank.com.studentApplication.building.model.ClassRoom;
import com.swedbank.com.studentApplication.exceptions.BuildingNotFoundException;
import com.swedbank.com.studentApplication.exceptions.RoomsNotFound;
import com.swedbank.com.studentApplication.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final BuildingRepository buildingRepository;

    private final RoomsRepository roomRepository;

    public List<Building> allBuildings() {
        return buildingRepository.findAll();
    }

    public List<ClassRoom> getBuildingRooms(int id){
        var building = buildingRepository.findById(id).orElseThrow(() -> new RoomsNotFound(id));

        return building.getRoomSet();
    }

    public ClassRoom addClassRoom(ClassRoom newRoom, int buildingId, long roomId) {
        Building building = buildingRepository.findById(buildingId).orElseThrow(() ->
                new BuildingNotFoundException(buildingId));
        return roomRepository.findById(roomId).map(room -> {
            room.setName(newRoom.getName());
            room.setCapacity(newRoom.getCapacity());
            room.setFloor(newRoom.getFloor());
            room.setBuilding(building);
            return roomRepository.save(room);
        }).orElseGet(() ->{newRoom.setId(roomId);
            newRoom.setBuilding(building);
            return roomRepository.save(newRoom);
        });
    }

    public ResponseEntity<ClassRoom> updateClassroom(long roomId, ClassRoom classRoomRequest) {

        ClassRoom classRoom = roomRepository.findById(roomId).orElseThrow(() -> new RoomsNotFound(roomId));

        classRoom.setId(classRoomRequest.getId());
        classRoom.setName(classRoomRequest.getName());
        classRoom.setFloor(classRoomRequest.getFloor());
        classRoom.setCapacity(classRoomRequest.getCapacity());
        final var updatedRoom = roomRepository.save(classRoom);

        return ResponseEntity.ok(updatedRoom);
    }




















}







