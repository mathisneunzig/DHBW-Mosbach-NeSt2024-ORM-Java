package de.mathisneunzig.ORM.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mathisneunzig.ORM.entities.Building;

public interface BuildingRepository extends JpaRepository<Building, UUID> {

}
