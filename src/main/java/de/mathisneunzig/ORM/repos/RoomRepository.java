package de.mathisneunzig.ORM.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mathisneunzig.ORM.entities.Room;

public interface RoomRepository extends JpaRepository<Room, UUID> {

}
