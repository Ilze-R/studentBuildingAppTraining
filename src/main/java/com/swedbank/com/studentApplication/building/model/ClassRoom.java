package com.swedbank.com.studentApplication.building.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.swedbank.com.studentApplication.building.model.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLASS_ROOM")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int floor;
    private int capacity;



    //        @JsonIgnore
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "building_id")
    private Building building;

}
