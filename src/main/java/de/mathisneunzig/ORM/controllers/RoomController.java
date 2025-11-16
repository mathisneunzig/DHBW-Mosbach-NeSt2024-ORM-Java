package de.mathisneunzig.ORM.controllers;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mathisneunzig.ORM.DTOs.CreateRoomDTO;
import de.mathisneunzig.ORM.DTOs.UpdateRoomDTO;
import de.mathisneunzig.ORM.entities.Building;
import de.mathisneunzig.ORM.entities.Room;
import de.mathisneunzig.ORM.repos.BuildingRepository;
import de.mathisneunzig.ORM.repos.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	BuildingRepository buildingRepository;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<Object>(roomRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getSpecific(@PathVariable UUID id){
		try {
			return new ResponseEntity<Object>(roomRepository.findById(id).get(), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> add(@RequestBody CreateRoomDTO room) {
	    try {
			Room newRoom = new Room();
			newRoom.setCapacity(room.getCapacity());
			newRoom.setName(room.getName());
			newRoom.setRoomNr(room.getRoomNr());
			newRoom.setType(room.getType());
	    	Building building = buildingRepository.findById(room.getBuildingId()).get();
	    	newRoom.setBuilding(building);
			return new ResponseEntity<Object>(roomRepository.save(newRoom), HttpStatus.CREATED);
	    }
	    catch (NoSuchElementException e) {
	        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UpdateRoomDTO room) {
	    try {
	        Room newRoom = roomRepository.findById(id).get();

	        if (room.getName() != null)
	        	newRoom.setName(room.getName());

	        if (room.getRoomNr() != null)
	        	newRoom.setRoomNr(room.getRoomNr());

	        if (room.getType() != null)
	        	newRoom.setType(room.getType());

	        if (room.getCapacity() != 0)
	        	newRoom.setCapacity(room.getCapacity());
	        
	        if (room.getBuildingId() != null) {
	        	Building building = buildingRepository.findById(room.getBuildingId()).get();
	        	newRoom.setBuilding(building);
	        }

	        return new ResponseEntity<Object>(roomRepository.save(newRoom), HttpStatus.CREATED);
	    }
	    catch (NoSuchElementException e) {
	        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		try {
			roomRepository.delete(roomRepository.findById(id).get());
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}