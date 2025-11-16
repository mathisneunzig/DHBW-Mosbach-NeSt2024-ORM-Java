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

import de.mathisneunzig.ORM.DTOs.UpdateBuildingDTO;
import de.mathisneunzig.ORM.entities.Building;
import de.mathisneunzig.ORM.repos.BuildingRepository;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

	@Autowired
	BuildingRepository buildingRepository;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<Object>(buildingRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getSpecific(@PathVariable UUID id){
		try {
			return new ResponseEntity<Object>(buildingRepository.findById(id).get(), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> add(@RequestBody Building building) {
		return new ResponseEntity<Object>(buildingRepository.save(building), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UpdateBuildingDTO building) {
	    try {
	        Building newBuilding = buildingRepository.findById(id).get();

	        if (building.getName() != null)
	            newBuilding.setName(building.getName());

	        if (building.getOpeningTime() != null)
	            newBuilding.setOpeningTime(building.getOpeningTime());

	        if (building.getClosingTime() != null)
	            newBuilding.setClosingTime(building.getClosingTime());

	        if (building.getStreet() != null)
	            newBuilding.setStreet(building.getStreet());

	        if (building.getHouseNr() != null)
	            newBuilding.setHouseNr(building.getHouseNr());

	        if (building.getZip() != null)
	            newBuilding.setZip(building.getZip());

	        if (building.getCity() != null)
	            newBuilding.setCity(building.getCity());

	        if (building.getCountry() != null)
	            newBuilding.setCountry(building.getCountry());

	        if (building.getType() != null)
	            newBuilding.setType(building.getType());

	        return new ResponseEntity<Object>(buildingRepository.save(newBuilding), HttpStatus.CREATED);
	    }
	    catch (NoSuchElementException e) {
	        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		try {
			buildingRepository.delete(buildingRepository.findById(id).get());
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}